package eu.vrtime.vaadinui.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;

import eu.vrtime.vaadinui.domain.Customer;
import eu.vrtime.vaadinui.repo.CustomerRepo;

public class FormComponent extends CustomComponent {

	private static final long serialVersionUID = 1L;
	
	private TextField customerId = new TextField("CustomerID");
	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private Grid<Customer> dataGrid;
	
	private CustomerRepo repo;
	
	private HorizontalLayout formLayout = new HorizontalLayout();
	
	public FormComponent(final String name, final CustomerRepo repo) {
		setCaption(name);
		this.repo=repo;
		
		dataGrid = createDataGrid();
		
		customerId.addShortcutListener(new ShortcutListener("shortcut", ShortcutAction.KeyCode.ENTER,null) {

			private static final long serialVersionUID = 1L;

			@Override
			public void handleAction(Object sender, Object target) {
				
				if(customerId.getValue()!=null) {
					List<Customer> customers = repo.findByCustomerIdStartsWithIgnoreCase(customerId.getValue());
					if (customers.size()>0 && customers != null) {
						dataGrid.setItems(customers);
						
					} else {
						Notification.show("Customer not found", Type.WARNING_MESSAGE);
					}

				}		
			}
		});
		formLayout.addComponents(customerId,firstName,lastName,dataGrid);
		
		setCompositionRoot(formLayout);
	}
	
	private Grid createDataGrid() {
		Grid<Customer> dataGrid = new Grid<>();
		dataGrid.addColumn(Customer::getCustomerId).setCaption("Customer ID");
		dataGrid.addColumn(Customer::getFirstName).setCaption("First Name");
		dataGrid.addColumn(Customer::getLastName).setCaption("Last Name");
		dataGrid.setHeightByRows(2);
		dataGrid.setWidth("800px");
		dataGrid.addItemClickListener(event -> Notification.show(event.getItem().toString()));
		return dataGrid;
	}
	
	

}
