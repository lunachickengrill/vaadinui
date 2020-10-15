package eu.vrtime.vaadinui.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class FormWindowComponent extends Window {

	private static final long serialVersionUID = 1L;

	FormLayout layout = new FormLayout();
	TextField someFormField = new TextField("someFormField");
	TextField anotherFormField = new TextField("anotherFormField");

	public FormWindowComponent(final String name) {
		super(name);
		
		center();
		addTextFields();
		layout.setSizeUndefined();
		layout.setMargin(true);

		setContent(layout);
		setClosable(true);

	}

	private void addTextFields() {
		layout.addComponent(someFormField);
		layout.addComponent(anotherFormField);
		layout.addComponent(new Button("Click", new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show(someFormField != null && anotherFormField != null
						? someFormField.getValue() + " " + anotherFormField.getValue()
						: "blub,blub,blub");

			}
		}));

	}

}
