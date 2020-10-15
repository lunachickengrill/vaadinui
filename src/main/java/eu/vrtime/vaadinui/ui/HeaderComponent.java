package eu.vrtime.vaadinui.ui;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class HeaderComponent extends CustomComponent{

	private static final long serialVersionUID = 1L;
	
	private HorizontalLayout containerLayout = new HorizontalLayout();
	private HorizontalLayout imageLayout = new HorizontalLayout();
	
	public HeaderComponent(final String name) {

		containerLayout.setSizeFull();
		containerLayout.setHeight("134px");
		
		Label label = new Label(name);
		label.setStyleName("H1");

		Image img = new Image();
		img.setSource(new ThemeResource("img/bond.png"));
		
		imageLayout.addComponent(img);
		imageLayout.addComponent(label);
		imageLayout.setComponentAlignment(label, Alignment.TOP_CENTER);
		
		containerLayout.addComponent(imageLayout);
		containerLayout.setStyleName("bottomLineSteelblue");
		containerLayout.setMargin(false);
		setCompositionRoot(containerLayout);
		
		
	}
	

}
