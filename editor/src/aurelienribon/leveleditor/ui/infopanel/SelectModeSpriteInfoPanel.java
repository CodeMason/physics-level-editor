package aurelienribon.leveleditor.ui.infopanel;

import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.ui.Theme;
import aurelienribon.utils.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SelectModeSpriteInfoPanel extends InfoPanelChild {
	private final List<SpriteModel> models = new ArrayList<SpriteModel>();

    public SelectModeSpriteInfoPanel() {
        initComponents();
    }

	@Override
	public void setModels(List<Object> objs) {
		for (SpriteModel model : models)
			model.removeChangeListener(modelListener);
		models.clear();
		if (objs != null) {
			assert !objs.isEmpty();
			for (Object obj : objs) {
				models.add((SpriteModel)obj);
				((SpriteModel)obj).addChangeListener(modelListener);
			}
			update();
		}
	}

	private final ChangeListener modelListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			update();
		}
	};

	private void update() {
		updateX();
		updateY();
		updateW();
		updateH();
		updateR();
	}

	private void updateX() {
		float val = models.get(0).getX();
		for (int i=1, n=models.size(); i<n; i++) {
			if (models.get(i).getX() != val) {
				xField.setText("---");
				return;
			}
		}
		xField.setText(String.format(Locale.US, "%.2f", val));
	}

	private void updateY() {
		float val = models.get(0).getY();
		for (int i=1, n=models.size(); i<n; i++) {
			if (models.get(i).getY() != val) {
				yField.setText("---");
				return;
			}
		}
		yField.setText(String.format(Locale.US, "%.2f", val));
	}

	private void updateW() {
		float val = models.get(0).getWidth();
		for (int i=1, n=models.size(); i<n; i++) {
			if (models.get(i).getWidth() != val) {
				wField.setText("---");
				return;
			}
		}
		wField.setText(String.format(Locale.US, "%.2f", val));
	}

	private void updateH() {
		float val = models.get(0).getHeight();
		for (int i=1, n=models.size(); i<n; i++) {
			if (models.get(i).getHeight() != val) {
				hField.setText("---");
				return;
			}
		}
		hField.setText(String.format(Locale.US, "%.2f", val));
	}

	private void updateR() {
		float val = models.get(0).getRotation();
		for (int i=1, n=models.size(); i<n; i++) {
			if (models.get(i).getRotation() != val) {
				rField.setText("---");
				return;
			}
		}
		rField.setText(String.format(Locale.US, "%.2f", val));
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hField = new javax.swing.JTextField();
        xField = new javax.swing.JTextField();
        yField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        wField = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        uniSizeBtn = new javax.swing.JButton();

        setOpaque(false);

        jPanel1.setOpaque(false);

        hField.setBackground(Theme.TEXTAREA_BACKGROUND);
        hField.setForeground(Theme.TEXTAREA_FOREGROUND);
        hField.setText("---");

        xField.setBackground(Theme.TEXTAREA_BACKGROUND);
        xField.setForeground(Theme.TEXTAREA_FOREGROUND);
        xField.setText("---");

        yField.setBackground(Theme.TEXTAREA_BACKGROUND);
        yField.setForeground(Theme.TEXTAREA_FOREGROUND);
        yField.setText("---");

        jLabel4.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel4.setText("width:");

        jLabel3.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel3.setText("height:");

        jLabel2.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel2.setText("y:");

        rField.setBackground(Theme.TEXTAREA_BACKGROUND);
        rField.setForeground(Theme.TEXTAREA_FOREGROUND);
        rField.setText("---");

        jLabel5.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel5.setText("rotation:");

        jLabel1.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel1.setText("x:");

        wField.setBackground(Theme.TEXTAREA_BACKGROUND);
        wField.setForeground(Theme.TEXTAREA_FOREGROUND);
        wField.setText("---");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {hField, rField, wField, xField, yField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(rField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_edit.png"))); // NOI18N
        updateBtn.setText("Update");
        updateBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        updateBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        updateBtn.setOpaque(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        uniSizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_shape.png"))); // NOI18N
        uniSizeBtn.setText("Uniformize size");
        uniSizeBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        uniSizeBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        uniSizeBtn.setOpaque(false);
        uniSizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniSizeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(uniSizeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(uniSizeBtn))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
		try {
			Float x = parse(xField);
			Float y = parse(yField);
			Float w = parse(wField);
			Float h = parse(hField);
			Float r = parse(rField);
			for (SpriteModel model : models) {
				if (x != null) model.setPosition(x, model.getY());
				if (y != null) model.setPosition(model.getX(), y);
				if (w != null) model.setSize(w, model.getHeight());
				if (h != null) model.setSize(model.getWidth(), h);
				if (r != null) model.setRotation(r);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Invalid character somewhere (guess where).");
		}
	}//GEN-LAST:event_updateBtnActionPerformed

	private void uniSizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniSizeBtnActionPerformed
		for (SpriteModel model : models) {
			float ratio = model.getAsset().getSizeRatio();
			model.setSize(model.getWidth(), model.getWidth() / ratio);
		}
	}//GEN-LAST:event_uniSizeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField rField;
    private javax.swing.JButton uniSizeBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField wField;
    private javax.swing.JTextField xField;
    private javax.swing.JTextField yField;
    // End of variables declaration//GEN-END:variables

	private Float parse(JTextField field) {
		String txt = field.getText();
		if (txt.equals("---"))
			return null;
		return Float.parseFloat(txt);
	}
}
