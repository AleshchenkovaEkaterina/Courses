package ImprovedShoppingList;

import java.util.Map;
import java.util.TreeMap;

public class ImprovedShoppingList {
    TreeMap<String, TreeMap<String, Integer>> clients = new
            TreeMap<String, TreeMap<String, Integer>>();

    public void improvedshoppinglist(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("exit")) {
                break;
            }
            String[] parts = s.split(" ");
            String name = parts[0];
            String productName = parts[1];
            Integer count = Integer.parseInt(parts[2]);

            if (!clients.containsKey(name))
                clients.put(name, new TreeMap<String, Integer>());

            TreeMap<String, Integer> temp = clients.get(name);

            if (!temp.containsKey(productName))
                temp.put(productName, 0);

            Integer oldCount = temp.get(productName);
            temp.put(productName, oldCount + count);
        }
        TreeMap<String, Integer> value = null;
        for (Map.Entry<String, TreeMap<String, Integer>> entry :
                clients.entrySet()) {
            String key = entry.getKey();
            value = entry.getValue();
//Выводим имя покупателя
            System.out.println(key + ":");
        }
        if (value != null) {
            for (Map.Entry<String, Integer> product : value.entrySet()) {
                String keyProduct = product.getKey();
                Integer valueProduct = product.getValue();
                System.out.println(keyProduct + " " + valueProduct);
            }
        }
    }
}
