package aurelienribon.leveleditor.models;

import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Measurable;
import aurelienribon.leveleditor.models.behaviors.Nameable;
import aurelienribon.leveleditor.models.behaviors.Selectable;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import aurelienribon.utils.InnerChangeableObject;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SpriteModel implements Measurable, Changeable, Nameable, Hideable, Selectable {
	private final AssetInfo asset;

	public SpriteModel(AssetInfo asset) {
		assert asset != null;
		this.asset = asset;
	}

	public AssetInfo getAsset() {
		return asset;
	}

	// -------------------------------------------------------------------------
	// Measurable impl.
	// -------------------------------------------------------------------------

	private float x;
	private float y;
	private float width;
	private float height;
	private float rotation;

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getWidth() {
		return width;
	}

	@Override
	public float getHeight() {
		return height;
	}


	@Override
	public float getRotation() {
		return rotation;
	}

	@Override
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		cho.firePropertyChanged(this, "x");
		cho.firePropertyChanged(this, "y");
	}

	@Override
	public void setSize(float w, float h) {
		this.width = w;
		this.height = h;
		cho.firePropertyChanged(this, "width");
		cho.firePropertyChanged(this, "height");
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
		cho.firePropertyChanged(this, "rotation");
	}

	// -------------------------------------------------------------------------
	// Changeable impl.
	// -------------------------------------------------------------------------

	private final InnerChangeableObject cho = new InnerChangeableObject();

	@Override
	public void addChangeListener(ChangeListener l) {
		cho.addChangeListener(l);
	}

	@Override
	public void removeChangeListener(ChangeListener l) {
		cho.removeChangeListener(l);
	}

	// -------------------------------------------------------------------------
	// Nameable impl.
	// -------------------------------------------------------------------------

	private String name;

	@Override
	public String getName() {
		if (name == null || name.equals(""))
			name = "<unamed - " + asset.getName() + ">";
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		cho.firePropertyChanged(this, "name");
	}

	// -------------------------------------------------------------------------
	// Hideable impl.
	// -------------------------------------------------------------------------

	private boolean visible = true;

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
		cho.firePropertyChanged(this, "visible");
	}

	// -------------------------------------------------------------------------
	// Selectable impl.
	// -------------------------------------------------------------------------

	private boolean selected = false;

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.selected = selected;
		cho.firePropertyChanged(this, "selected");
	}
}
