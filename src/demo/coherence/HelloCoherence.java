package demo.coherence;

import java.util.Map;
import java.util.Set;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

@SuppressWarnings({"unchecked"})
public class HelloCoherence {

    public static void main(String[] args) {
        NamedCache countries = CacheFactory.getCache("countries");

        // first, we need to put some countries into the cache
        countries.put("USA", new Country("USA", "United States", "Washington", "USD", "Dollar"));
        countries.put("GBR", new Country("GBR", "United Kingdom", "London", "GBP", "Pound"));
        countries.put("RUS", new Country("RUS", "Russia", "Moscow", "RUB", "Ruble"));
        countries.put("CHN", new Country("CHN", "China", "Beijing", "CNY", "Yuan"));
        countries.put("JPN", new Country("JPN", "Japan", "Tokyo", "JPY", "Yen"));
        countries.put("DEU", new Country("DEU", "Germany", "Berlin", "EUR", "Euro"));
        countries.put("FRA", new Country("FRA", "France", "Paris", "EUR", "Euro"));
        countries.put("ITA", new Country("ITA", "Italy", "Rome", "EUR", "Euro"));
        countries.put("SRB", new Country("SRB", "Serbia", "Belgrade", "RSD", "Dinar"));
        assert countries.containsKey("JPN") : "Japan is not in the cache";

        // get and print a single country
        System.out.println("get(SRB) = " + countries.get("SRB"));

        // remove Italy from the cache
        int size = countries.size();
        System.out.println("remove(ITA) = " + countries.remove("ITA"));
        assert countries.size() == size - 1 : "Italy was not removed";

        // list all cache entries
        Set<Map.Entry<String, Country>> entries = countries.entrySet(null, null);
        for (Map.Entry<String, Country> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

}
