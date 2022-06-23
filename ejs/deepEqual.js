//chapter 4 - Data Structures objects and arrays

function deepEqual(valueOne, valueTwo) {
    if (typeof valueOne !== 'object' && typeof valueTwo !== 'object') {
        const isValueOneNaN = isNaN(valueOne) && typeof valueOne === 'number';
        const isValueTwoNaN = isNaN(valueTwo) && typeof valueTwo === 'number';

        if (isValueOneNaN && isValueTwoNaN) return true;

        return valueOne === valueTwo;
    }
    if (typeof valueOne !== typeof valueTwo) return false;
    if (valueOne === null && valueTwo === null) return true;
    if (valueOne === null || valueTwo === null) return false;
    if (valueOne === valueTwo) return true;

    if (Array.isArray(valueOne) && Array.isArray(valueTwo)) {
        if (valueOne.length !== valueTwo.length) return false;
        for (let i = 0; i < valueOne.length; i++) {
            if (!deepEqual(valueOne[i], valueTwo[i])) return false
        }
        return true;
    }
    if (Array.isArray(valueOne) || Array.isArray(valueTwo)) return false;

    const valueOneKeys = Object.keys(valueOne);
    const valueTwoKeys = Object.keys(valueTwo);
    if (valueOneKeys.length !== valueTwoKeys.length) return false;
    if(!deepEqual(valueOneKeys, valueTwoKeys)) return false;

    for (let i = 0; i < valueOneKeys.length; i++) {
        const key = valueOneKeys[i];
        if (!deepEqual(valueOne[key], valueTwo[key])) return false;
    }
    return true;
}
//unit tests
console.log('TRUE cases\n');
console.log(deepEqual(1,1));
console.log(deepEqual('a', 'a'));
console.log(deepEqual(NaN, NaN));
console.log(deepEqual([],[]));
console.log(deepEqual([1,2,[3,4]], [1,2,[3,4]]));
console.log(deepEqual([[1,2],[3,4]], [[1,2],[3,4]]));
console.log(deepEqual({}, {}));
console.log(deepEqual({a: 1}, {a: 1}));
console.log(deepEqual({a: 1, obj: {b: 2}}, {a: 1, obj: {b: 2}}));
console.log(deepEqual(null, null));
console.log(deepEqual(undefined, undefined));
const array = new Array(100000).fill('a');
console.log(deepEqual(array, array));

console.log('\nFALSE cases\n');
console.log(deepEqual(1,''));
console.log(deepEqual('a', 'b'));
console.log(deepEqual(NaN, 'a'));
console.log(deepEqual([],[2]));
console.log(deepEqual([1,2,[3,4, 5]], [1,2,[3,4]]));
console.log(deepEqual([[1,2],[3,4]], [[1,2], []]));
console.log(deepEqual({}, undefined));
console.log(deepEqual({a: 1}, {b: 2}));
console.log(deepEqual({a: 1, obj: {b: 2}}, {a: 1, obj: {b: 2, c: 3}}));
console.log(deepEqual(null, 1));
console.log(deepEqual(undefined, {}));
const obj1 = {a: undefined, b: 1};
const obj2 = {b: 2, c: 3}
console.log(deepEqual(obj1, obj2));
