import java.util.ArrayList;
import java.util.LinkedList;
public class h4{
    public static class HashMap<K,V>{
        class Node{
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        public int nodesize;
        public int bucketSize; 
        public  LinkedList<Node>[] map ;
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.bucketSize = 4;
            map = new LinkedList[bucketSize];
            for(int i=0;i<bucketSize;i++){
                map[i] = new LinkedList<>();
            }
        }
        private int  hash(K key){
            int h = key.hashCode();
            return (Math.abs(h) % bucketSize) ;
        }
        private int searchInList(K key, int bi){
            LinkedList<Node> l = map[bi];
            for(int i=0;i<l.size();i++){
                if(l.get(i).key.equals(key)){
                    return i ;
                }
            }
            return -1 ;
        }
        @SuppressWarnings("unchecked")
        public void resizeBucket(){
            
            LinkedList<Node> oldBucket[] = map;
            map = new LinkedList[bucketSize*2];
            bucketSize = bucketSize*2;
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> l = oldBucket[i];
                if(l!=null){
                    for(int j=0;j<l.size();j++){
                        Node oldnode = l.get(j);
                        put(oldnode.key,oldnode.value);
                    }
                }
            }
            

        }
        public void put(K key,V value){
            int bucketIndex = hash(key);
            int listIndex = searchInList(key,bucketIndex);
            if(listIndex != -1){
                map[bucketIndex].get(listIndex).value = value;
            }else{
                Node newNode = new Node(key,value);
                map[bucketIndex].add(newNode);
                nodesize++;
            }
            
            double lambda = (double) nodesize / bucketSize ;
            if(lambda > 2){
                resizeBucket();
            }
        }

        public V get(K key){
            int bi = hash(key);
            int si = searchInList(key, bi);
            if(si!=-1){
                return map[bi].get(si).value;
            }
            return null;
        }

        public boolean containsKey(K key){
            int bi = hash(key);
            int si = searchInList(key, bi);
            return si!=-1;
        }

        public V remove(K key){
            int bi = hash(key);
            int si = searchInList(key, bi);
            if(si!=-1){
                V ans = map[bi].get(si).value;
                map[bi].remove(si);
                nodesize--;
                return ans;
            }else{
                return null;
            }
        }
        public int size(){
            return nodesize;
        }

        public boolean isEmpty(){
            return nodesize==0;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int bi=0;bi<map.length;bi++){
                for(int si=0;si<map[bi].size();si++ ){
                    keys.add(map[bi].get(si).key);
                }
            }

            return keys;
            

        }
    }
   
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("hello",1);
        hm.put("world",2);
        System.out.println(hm.get("hello"));
        System.out.println(hm.containsKey("world"));
        System.out.println(hm.containsKey("rld"));
        hm.put( "world", 3);
        hm.put("helloworld",5);
        System.out.println("checking size.........");
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        System.out.println("taking keys...........");
        for(String k : hm.keySet()){
            System.out.println(k);
        }
        System.out.println("removing hello........................");
        System.out.println( hm.remove("hello"));
       
        System.out.println("checking size.........");
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        
    }
}