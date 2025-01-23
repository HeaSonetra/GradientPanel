
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.util.ArrayList;
import java.util.List;

public class Gradient extends javax.swing.JPanel {

    /**
     * Creates new form Gradient
     */
    public Gradient() {
        initComponents();
        colors=new ArrayList<>();
        setOpaque(false);
    }

    private  List<ModelColor> colors;
    
    public void addColor(ModelColor... color) {
        for (ModelColor c : color) {
            colors.add(c);
        }
        repaint(); // Trigger a repaint to apply new colors
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (colors.isEmpty()) return;
         Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Prepare arrays for gradient stops
        float[] fractions = new float[colors.size()];
        Color[] gradientColors = new Color[colors.size()];

        for (int i = 0; i < colors.size(); i++) {
            fractions[i] = colors.get(i).getPosition();
            gradientColors[i] = colors.get(i).getColor();
        }

        // Create a horizontal linear gradient
        LinearGradientPaint gradientPaint = new LinearGradientPaint(
            0, 0, width, 0, // Start and end points (horizontal gradient)
            fractions, gradientColors
        );

        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height); // Fill the panel with the gradient
    }
}
