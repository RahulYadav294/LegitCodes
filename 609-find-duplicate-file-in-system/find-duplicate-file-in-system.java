class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : paths){
            String[] part = str.split(" ");
            for(int i = 1; i<part.length; i++){
                int idx = part[i].indexOf('(');
                String filename = part[i].substring(0,idx);
                String content = part[i].substring(idx+1,part[i].length()-1);
                String fullPath = part[0] + "/" + filename;
                if(!map.containsKey(content)){
                    map.put(content,new ArrayList<>());
                }
                map.get(content).add(fullPath);
            }
        }
        for(List<String> lists : map.values()){
            if(lists.size() > 1){
            list.add(lists);
            }
        }
        return list;
    }
}