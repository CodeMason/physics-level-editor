package aurelienribon.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public abstract class MutableTreeModel implements TreeModel {
	private final EventListenerList listeners = new EventListenerList();
	private final ObservableList root;

	public MutableTreeModel(ObservableList root) {
		this.root = root;
		registerRoot(root);
		root.addListChangedListener(modelListener);
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		if (parent instanceof ObservableList)
			return ((ObservableList)parent).get(index);
		assert false;
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		int size = 0;
		if (parent instanceof ObservableList)
			size = ((ObservableList)parent).size();
		return size;
	}

	@Override
	public boolean isLeaf(Object node) {
		return !(node instanceof ObservableList);
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent == null || child == null)
			return -1;
		if (parent instanceof ObservableList)
			return ((ObservableList)parent).indexOf((ObservableList)child);
		assert false;
		return -1;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(TreeModelListener.class, l);
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(TreeModelListener.class, l);
	}

	// -------------------------------------------------------------------------
	// Paths
	// -------------------------------------------------------------------------

	private final Map<Object, Object[]> pathsMap = new HashMap<Object, Object[]>(100);

	public Map<Object, Object[]> getPathsMap() {
		return Collections.unmodifiableMap(pathsMap);
	}

	private void registerRoot(ObservableList root) {
		pathsMap.put(root, new Object[] {root});
		for (Object child : root.getAll())
			registerElement(root, child);
	}

	private void registerElement(Object parent, Object child) {
		assert child != null;
		assert pathsMap.containsKey(parent);

		Object[] parentPath = pathsMap.get(parent);
		Object[] childPath = new Object[parentPath.length+1];
		System.arraycopy(parentPath, 0, childPath, 0, parentPath.length);
		childPath[childPath.length-1] = child;
		pathsMap.put(child, childPath);

		if (child instanceof Changeable)
			((Changeable)child).addChangeListener(elemChangeListener);

		if (child instanceof ObservableList) {
			ObservableList list = (ObservableList)child;
			list.addListChangedListener(modelListener);
			for (Object childChild : list.getAll())
				registerElement(child, childChild);
		}
	}

	private void unregisterElement(Object elem) {
		assert pathsMap.containsKey(elem);
		pathsMap.remove(elem);

		if (elem instanceof Changeable)
			((Changeable)elem).removeChangeListener(elemChangeListener);

		if (elem instanceof ObservableList) {
			ObservableList list = (ObservableList)elem;
			list.removeListChangedListener(modelListener);
			for (Object child : list.getAll())
				unregisterElement(child);
		}
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private void fireNodeAdded(Object parent, int childIdx, Object child) {
		assert pathsMap.containsKey(parent);
		TreeModelEvent evt = new TreeModelEvent(this, pathsMap.get(parent), new int[]{childIdx}, new Object[]{child});
		for (TreeModelListener listener : listeners.getListeners(TreeModelListener.class))
			listener.treeNodesInserted(evt);
	}

	private void fireNodeRemoved(Object parent, int childIdx, Object child) {
		assert pathsMap.containsKey(parent);
		TreeModelEvent evt = new TreeModelEvent(this, pathsMap.get(parent), new int[]{childIdx}, new Object[]{child});
		for (TreeModelListener listener : listeners.getListeners(TreeModelListener.class))
			listener.treeNodesRemoved(evt);
	}

	private void fireNodeChanged(Object parent) {
		assert pathsMap.containsKey(parent);
		TreeModelEvent evt = new TreeModelEvent(this, pathsMap.get(parent));
		for (TreeModelListener listener : listeners.getListeners(TreeModelListener.class))
			listener.treeNodesChanged(evt);
	}

	// -------------------------------------------------------------------------
	// Listeners
	// -------------------------------------------------------------------------

	private final ObservableList.ListChangeListener modelListener = new ObservableList.ListChangeListener() {
		@Override
		public void elementAdded(Object source, int idx, Object elem) {
			registerElement(source, elem);
			fireNodeAdded(source, idx, elem);
		}

		@Override
		public void elementRemoved(Object source, int idx, Object elem) {
			unregisterElement(elem);
			fireNodeRemoved(source, idx, elem);
		}
	};

	private final ChangeListener elemChangeListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			fireNodeChanged(source);
		}
	};
}
