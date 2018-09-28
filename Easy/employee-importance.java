// Assuming there may be cycles or one emp is indirect descendent of miltiple employees
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(int i=0;i<employees.size();i++) {
            Employee emp = employees.get(i);
            map.put(emp.id, emp);
        }
        Employee employee = map.get(id);
        int imp = employee.importance;
        HashSet<Integer> subIdSet = new HashSet<>();
        Stack<Integer> subIdSt = new Stack<>();
        subIdSet.add(id);
        subIdSt.push(id);
        while(!subIdSt.isEmpty()) {
            Employee emp = map.get(subIdSt.pop());
            List<Integer> subIds = emp.subordinates;
            for(int i=0;i<subIds.size();i++) {
                int subId = subIds.get(i);
                if(!subIdSet.contains(subId)) {
                    imp += map.get(subId).importance;
                    subIdSet.add(subId);
                    subIdSt.push(subId);
                }
            }
        }
        return imp;
    }
}
