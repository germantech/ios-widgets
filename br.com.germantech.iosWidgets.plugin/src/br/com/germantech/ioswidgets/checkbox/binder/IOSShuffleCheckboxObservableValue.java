package br.com.germantech.ioswidgets.checkbox.binder;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import br.com.germantech.ioswidgets.checkbox.IOSShuffleCheckbox;

public class IOSShuffleCheckboxObservableValue extends AbstractObservableValue implements ISWTObservableValue {
	
	private IOSShuffleCheckbox button;
	private Listener listener;
	private boolean oldValue;
	
	public IOSShuffleCheckboxObservableValue(IOSShuffleCheckbox check) {
		super(Realm.getDefault());
		this.button = check;
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
		return button.isSelected();
	}
	
	@Override
	protected void doSetValue(Object value) {
		button.setSelected(Boolean.valueOf(value.toString()));
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
