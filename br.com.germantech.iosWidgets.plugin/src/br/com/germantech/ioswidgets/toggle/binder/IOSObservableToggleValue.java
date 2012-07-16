package br.com.germantech.ioswidgets.toggle.binder;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import br.com.germantech.ioswidgets.toggle.IOSToggle;

public class IOSObservableToggleValue extends AbstractObservableValue implements ISWTObservableValue {
	
	private IOSToggle button;
	private Listener listener;
	private boolean oldValue;
	
	public IOSObservableToggleValue(IOSToggle imageButton) {
		super(Realm.getDefault());
		this.button = imageButton;
	}

	@Override
	public Widget getWidget() {
		return button;
	}

	@Override
	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Object doGetValue() {
		return button.isToggled();
	}
	
	@Override
	protected void doSetValue(Object value) {
		button.setToggled(Boolean.valueOf(value.toString()));
	}
	
	@Override
	protected void firstListenerAdded() {
		listener = new ModifyListener();
		button.addListener(SWT.MouseUp, listener);
		super.firstListenerAdded();
	}

	@Override
	protected void lastListenerRemoved() {
		button.removeListener(SWT.MouseUp, listener);
		super.lastListenerRemoved();
	}
	
	private class ModifyListener implements Listener {
		public void handleEvent(Event event) {
			Boolean newValue = !oldValue;
			fireValueChange(Diffs.createValueDiff(oldValue, newValue));
			oldValue = newValue;
		}
	}
}
