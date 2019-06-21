/**
 * @param {number[]} A
 * @param {number[][]} queries
 * @return {number[]}
 */
var sumEvenAfterQueries = function(A, queries) {
    var sum = 0;
    for(let i=0;i<A.length;i++) {
        if(A[i]%2==0) sum += A[i];
    }
    const arr = [];
    for(let i=0;i<queries.length;i++) {
        let index = queries[i][1];
        const oldVal = A[index];
        const newVal = A[index] + queries[i][0];
        if(oldVal % 2 !== 0 && newVal % 2 === 0) {
            sum = sum + newVal;
        } else if(oldVal % 2 === 0 && newVal % 2 !== 0) {
            sum = sum - oldVal;
        } else if(oldVal % 2 === 0 && newVal % 2 === 0){
            sum = sum - oldVal + newVal;
        }
        A[index] = newVal;
        arr.push(sum);
    }
    return arr;
};
