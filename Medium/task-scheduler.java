class Task {
    int latest;
    char c;
    int num;
    Task(char c, int n, int num) {
        this.c = c;
        this.latest = -n-1;
        this.num = num;
    }
    @Override
    public String toString() {
        return c + ": tasks rem = " + num + ", latest = " + latest;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);
        int[] freq = new int[26];
        int index = 0;
        int totalTasks = tasks.length;
        for(int i=0;i<tasks.length;) {
            char curr = tasks[i];
            while(i<tasks.length && tasks[i]==curr) {
                freq[index]++;
                i++;
            }
            index++;
        }
        int maxType = index;
        Task[] taskArr = new Task[maxType];
        for(int i=0;i< maxType;i++) {
            taskArr[i] = new Task((char)('A' + i), n, freq[i]);
        }
        int currIndex = 0;
        int currTime = 1;
        while(totalTasks > 0) {
            Arrays.sort(taskArr, new Comparator<Task>() {
                public int compare(Task i1, Task i2) {
                    return i1.num > i2.num ? -1 : (i1.num == i2.num ? (i1.latest < i2.latest ? -1 : 1) : 1);
                }
            });
            //System.out.println(Arrays.toString(taskArr));
            //System.out.println(currTime);
            //System.out.println(Arrays.toString(freq));
            //System.out.println(Arrays.toString(latest));
            if(currIndex < taskArr.length && taskArr[currIndex].num > 0 && currTime - taskArr[currIndex].latest > n) {
                taskArr[currIndex].num--;
                taskArr[currIndex].latest = currTime;
                totalTasks--;
                currTime++;
                currIndex = 0;
                currIndex = currIndex % maxType;
            } else if(currIndex < taskArr.length) {
                currIndex++;
            } else {
                currTime++;
                currIndex = 0;
            }
        }
        return currTime-1;
    }
}
