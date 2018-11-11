class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o) {
        Point p =(Point)o;
        return p.x == x && p.y == y;
    }
    public int hashCode() {
        return x + 13*y;
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<Point> set = new HashSet<>();
        for(int i=0;i<points.length;i++) {
            set.add(new Point(points[i][0], points[i][1]));
        }
        HashMap<Integer, ArrayList<Point>> mapx = new HashMap<>();
        HashMap<Integer, ArrayList<Point>> mapy = new HashMap<>();
        for(int i=0;i<points.length;i++) {
            if(!mapx.containsKey(points[i][0])) {
                mapx.put(points[i][0], new ArrayList<>());
            }
            mapx.get(points[i][0]).add(new Point(points[i][0], points[i][1]));
        }
        for(int key: mapx.keySet()) {
            Collections.sort(mapx.get(key), new Comparator<Point>() {
                public int compare(Point p1, Point p2) {
                    if(p1.y < p2.y) return 1;
                    if(p1.y > p2.y) return -1;
                    return 0;
                }
            });
        }
        for(int i=0;i<points.length;i++) {
            if(!mapy.containsKey(points[i][1])) {
                mapy.put(points[i][1], new ArrayList<>());
            }
            mapy.get(points[i][1]).add(new Point(points[i][0], points[i][1]));
        }
        for(int key: mapy.keySet()) {
            Collections.sort(mapy.get(key), new Comparator<Point>() {
                public int compare(Point p1, Point p2) {
                    if(p1.x < p2.x) return 1;
                    if(p1.x > p2.x) return -1;
                    return 0;
                }
            });
        }
        int minArea = Integer.MAX_VALUE;
        for(int key: mapx.keySet()) {
            for(int i=0;i<mapx.get(key).size();i++) {
                Point p1 = mapx.get(key).get(i);
                for(int j=i+1;j<mapx.get(key).size();j++) {
                    Point p2 = mapx.get(key).get(j); // p1 and p2 have same x
                    ArrayList<Point> list = mapy.get(p1.y);
                    //System.out.println("p1 = " + p1);
                    //System.out.println("p2 = " + p2);
                    //System.out.println(Arrays.toString(list.toArray()));
                    for(Point p3: list) {
                        if(set.contains(new Point(p3.x, p2.y)) && !p3.equals(p1)) {
                            int area = Math.abs(p1.y - p2.y) * Math.abs(p1.x - p3.x);
                            //System.out.println("area = " + area);
                            if(minArea > area) {
                                minArea = area;
                            }
                        }
                    }
                    
                }
            }
        }
        if(minArea == Integer.MAX_VALUE) {
            return 0;
        }
        return minArea;
        
    }
}
