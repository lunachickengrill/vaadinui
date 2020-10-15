package eu.vrtime.vaadinui.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import eu.vrtime.vaadinui.repo.CustomerRepo;

@SpringUI(path = "/test")
@Theme("LMAS")
public class AppUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VerticalLayout mainLayout = new VerticalLayout();

	private TextField someTextField = new TextField("someTextField");
	private TextField anohterTextField = new TextField("anohterTextField");
	private Button openWindowBtn;
	private HeaderComponent header;
	private FormWindowComponent form;
	private FormComponent formComponent;
	
	private CustomerRepo repo;

	@Autowired
	public AppUI(CustomerRepo repo) {
		this.repo=repo;
	}

	@Override
	protected void init(VaadinRequest request) {
		
		formComponent =  new FormComponent("form",repo);
		form = new FormWindowComponent("form in window");
		header = new HeaderComponent("dummy UI");
		openWindowBtn = new Button("Open Window");

		openWindowBtn.addClickListener(event -> {
			UI.getCurrent().addWindow(form);
		});
		
		mainLayout.addComponents(header, formComponent, openWindowBtn);

		setContent(mainLayout);

	}

}
