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
		shell.setSize(472, 355);
		shell.setText("iOS checkbox");
		shell.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblSimno = new Label(composite, SWT.NONE);
		lblSimno.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblSimno.setText("Sim/Não");
		
		IOSCheckbox iosCheckNao = new IOSCheckbox(composite);
		GridData gd_iosCheckNao = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_iosCheckNao.heightHint = 30;
		gd_iosCheckNao.widthHint = 78;
		iosCheckNao.setLayoutData(gd_iosCheckNao);
		new Label(composite, SWT.NONE);
		
		IOSCheckbox iosCheckSim = new IOSCheckbox(composite);
		iosCheckSim.setSelected(true);
		GridData gd_iosCheckSim = new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1);
		gd_iosCheckSim.heightHint = 30;
		iosCheckSim.setLayoutData(gd_iosCheckSim);
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label lblTextos = new Label(composite, SWT.NONE);
		lblTextos.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblTextos.setText("Textos");
		
		IOSCheckbox iosCheckHomologa = new IOSCheckbox(composite,"Produção", "Homologação");
		GridData gd_iosCheckHomologa = new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1);
		gd_iosCheckHomologa.heightHint = 30;
		iosCheckHomologa.setLayoutData(gd_iosCheckHomologa);
		
		Label label_1 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label lblFrases = new Label(composite, SWT.NONE);
		lblFrases.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblFrases.setText("Frases");
		
		IOSCheckbox iosCheckFrase = new IOSCheckbox(composite,"Frase bem longa aqui","Outra fase bem longa aqui");
		GridData gd_iosCheckFrase = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_iosCheckFrase.heightHint = 30;
		iosCheckFrase.setLayoutData(gd_iosCheckFrase);
		
		Label label_2 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label lblToggle = new Label(composite, SWT.NONE);
		lblToggle.setText("Toggle");
		
		IOSToggle toggle = new IOSToggle(composite, "Untoggle");
		GridData gd_toggle = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_toggle.heightHint = 38;
		gd_toggle.widthHint = 215;
		toggle.setLayoutData(gd_toggle);
		new Label(composite, SWT.NONE);
		
		IOSToggle toggle_1 = new IOSToggle(composite, "Toggled");
		toggle_1.setToggled(true);
		GridData gd_toggle_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_toggle_1.heightHint = 30;
		gd_toggle_1.widthHint = 151;
		toggle_1.setLayoutData(gd_toggle_1);
		
		Label lblNewLabel = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		lblNewLabel.setText("New Label");
		
		Label lblButto = new Label(composite, SWT.NONE);
		lblButto.setText("Button");
		
		IOSButton button = new IOSButton(composite, "Selection button");
		GridData gd_button = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button.heightHint = 34;
		gd_button.widthHint = 162;
		button.setLayoutData(gd_button);

	}
}
