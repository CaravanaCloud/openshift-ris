package cloud.caravana.console;

import java.io.Console;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import cloud.caravana.auth.ClientSession;

@Route("/user/home")
public class HomeView extends AppLayout {   
    Locale locale = Locale.ENGLISH;

    @Inject
    public HomeView(
            ClientSession session,
            ConsoleI18N i18n) {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1(i18n.getTranslation("app-name", locale));
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToDrawer(tabs);
        addToNavbar(toggle, title);
        /*
         * add(new Label("WhoAmI (rest client auth)? " + session.whoami()));
         * 
         * if (session != null && session.isLoggedIn()) {
         * add(new Label("Welcome home " + session.getUserInfo()));
         * } else {
         * add(new Label("You should be authenticated to be here :/"));
         * }
         */
    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.add(
          createTab(VaadinIcon.PRESENTATION, "Submit a Talk!"),
          createTab(VaadinIcon.DASHBOARD, "Dashboard"),
          createTab(VaadinIcon.CART, "Orders"),
          createTab(VaadinIcon.USER_HEART, "Customers"),
          createTab(VaadinIcon.PACKAGE, "Products"),
          createTab(VaadinIcon.RECORDS, "Documents"),
          createTab(VaadinIcon.LIST, "Tasks"),
          createTab(VaadinIcon.CHART, "Analytics")
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
      }
    
      private Tab createTab(VaadinIcon viewIcon, String viewName) {
        var icon = viewIcon.create();
        icon.getStyle()
                .set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");
    
        RouterLink link = new RouterLink();
        link.add(icon, new Span(viewName));
        // Demo has no routes
        // link.setRoute(viewClass.java);
        link.setTabIndex(-1);
    
        return new Tab(link);
      }
}
