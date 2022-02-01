package cloud.caravana.console;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.enterprise.context.Dependent;

import com.vaadin.flow.i18n.I18NProvider;

@Dependent
public class ConsoleI18N implements I18NProvider{
    public static final String RESOURCE_BUNDLE_NAME = "console-app";
    private static final Locale EN = Locale.ENGLISH;
    private static final Locale PT = new Locale("PT");
    private static final List<Locale> providedLocales = List.of(EN, PT);
    
    static final Map<Locale, ResourceBundle> bundles = new HashMap<>(){{
        put(EN, ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, EN));
        put(PT, ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, PT));
    }};

    @Override
    public List<Locale> getProvidedLocales() {
      return providedLocales;
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
    var resourceBundle = bundles.get(locale);

    if (! resourceBundle.containsKey(key)) {
      System.out.println("missing resource key (i18n) " + key);
      return key + " - " + locale;
    } else {
      return (resourceBundle.containsKey(key)) ? resourceBundle.getString(key) : key;
    }
    }

}