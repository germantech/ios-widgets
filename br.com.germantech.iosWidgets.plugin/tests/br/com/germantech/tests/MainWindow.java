package br.com.germantech.tests;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import br.com.germantech.ioswidgets.checkbox.IOSCheckbox;
import br.com.germantech.ioswidgets.toggle.IOSToggle;
import br.com.germantech.ioswidgets.button.IOSButton;
import br.com.germantech.ioswidgets.slider.IOSSlider;
import br.com.germantech.ioswidgets.slider.listener.IOSSliderListener;
import br.com.germantech.ioswidgets.checkbox.IOSShuffleCheckbox;
import org.eclipse.swt.widgets.Group;

public class MainWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.MIN | SWT.CLOSE);
		shell.setSize(417, 496);
		shell.setText("iOS widgets");
		shell.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group grpCheckboxes = new Group(composite, SWT.NONE);
		grpCheckboxes.setText("Checkboxes");
		grpCheckboxes.setLayout(new GridLayout(2, false));
		GridData gd_grpCheckboxes = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_grpCheckboxes.heightHint = 185;
		grpCheckboxes.setLayoutData(gd_grpCheckboxes);
		
		Label lblSimno = new Label(grpCheckboxes, SWT.NONE);
		lblSimno.setText("Default values");
		
		IOSCheckbox iosCheckNao = new IOSCheckbox(grpCheckboxes);
		GridData gd_iosCheckNao = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_iosCheckNao.widthHint = 136;
		gd_iosCheckNao.heightHint = 29;
		iosCheckNao.setLayoutData(gd_iosCheckNao);
		new Label(grpCheckboxes, SWT.NONE);
		
		IOSCheckbox iosCheckSim = new IOSCheckbox(grpCheckboxes);
		GridData gd_iosCheckSim = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_iosCheckSim.heightHint = 29;
		gd_iosCheckSim.widthHint = 147;
		iosCheckSim.setLayoutData(gd_iosCheckSim);
		iosCheckSim.setSelected(true);
		
		Label lblNewLabel_4 = new Label(grpCheckboxes, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblNewLabel_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		lblNewLabel_4.setText("New Label");
		
		Label lblTextos = new Label(grpCheckboxes, SWT.NONE);
		lblTextos.setText("Words");
		
		IOSCheckbox iosCheckHomologa = new IOSCheckbox(grpCheckboxes,"Produção", "Homologação");
		GridData gd_iosCheckHomologa = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_iosCheckHomologa.heightHint = 29;
		gd_iosCheckHomologa.widthHint = 217;
		iosCheckHomologa.setLayoutData(gd_iosCheckHomologa);
		
		Label label = new Label(grpCheckboxes, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		label.setText("New Label");
		
		Label lblVisualInf = new Label(grpCheckboxes, SWT.NONE);
		lblVisualInf.setText("Shuffle checkbox");
		
		IOSShuffleCheckbox visualCheckboxGreen = new IOSShuffleCheckbox(grpCheckboxes);
		GridData gd_visualCheckboxGreen = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_visualCheckboxGreen.widthHint = 155;
		gd_visualCheckboxGreen.heightHint = 29;
		visualCheckboxGreen.setLayoutData(gd_visualCheckboxGreen);
		visualCheckboxGreen.setSelected(true);
		new Label(grpCheckboxes, SWT.NONE);
		
		IOSShuffleCheckbox shuffleCheckboxRed = new IOSShuffleCheckbox(grpCheckboxes, true);
		GridData gd_shuffleCheckboxRed = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_shuffleCheckboxRed.widthHint = 150;
		gd_shuffleCheckboxRed.heightHint = 29;
		shuffleCheckboxRed.setLayoutData(gd_shuffleCheckboxRed);
		shuffleCheckboxRed.setSelected(true);
		
		Group grpToggle = new Group(composite, SWT.NONE);
		grpToggle.setText("Toggle");
		grpToggle.setLayout(new GridLayout(1, false));
		GridData gd_grpToggle = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_grpToggle.heightHint = 69;
		grpToggle.setLayoutData(gd_grpToggle);
		
		IOSToggle toggle = new IOSToggle(grpToggle, "Untoggle");
		GridData gd_toggle = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_toggle.heightHint = 29;
		gd_toggle.widthHint = 126;
		toggle.setLayoutData(gd_toggle);
		
		IOSToggle toggle_1 = new IOSToggle(grpToggle, "Toggled");
		GridData gd_toggle_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_toggle_1.heightHint = 29;
		gd_toggle_1.widthHint = 123;
		toggle_1.setLayoutData(gd_toggle_1);
		toggle_1.setToggled(true);
		
		Group grpButton = new Group(composite, SWT.NONE);
		grpButton.setText("Button");
		grpButton.setLayout(new GridLayout(1, false));
		GridData gd_grpButton = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_grpButton.heightHint = 40;
		grpButton.setLayoutData(gd_grpButton);
		
		IOSButton button = new IOSButton(grpButton, "Selection button");
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_button.heightHint = 29;
		gd_button.widthHint = 142;
		button.setLayoutData(gd_button);
		
		Group grpSlider = new Group(composite, SWT.NONE);
		grpSlider.setText("Slider");
		grpSlider.setLayout(new GridLayout(1, false));
		GridData gd_grpSlider = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_grpSlider.heightHint = 72;
		grpSlider.setLayoutData(gd_grpSlider);
		
		final Label lblNewLabel_3 = new Label(grpSlider, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		
		lblNewLabel_3.setText("Position: 0");
		
		IOSSlider slider = new IOSSlider(grpSlider, 200);
		GridData gd_slider = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_slider.heightHint = 29;
		slider.setLayoutData(gd_slider);
		slider.addIOSSliderListener(new IOSSliderListener() {
			
			@Override
			public void fire(int position) {
				lblNewLabel_3.setText("Position: "+position);
			}
		});
		slider.setTotalSize(250);

	}
}
