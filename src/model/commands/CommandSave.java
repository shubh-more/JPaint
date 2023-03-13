package model.commands;

import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CommandSave implements InterfaceCommand {

    private static PaintCanvas paintCanvas;
    FunctionsOfShapes functionsOfShapes;

    public CommandSave(PaintCanvasBase paintCanvas, FunctionsOfShapes functionsOfShapes)
    {
        this.paintCanvas=(PaintCanvas) paintCanvas;
        this.functionsOfShapes = functionsOfShapes;
    }


    @Override
    public void run() {
        BufferedImage image = new BufferedImage(paintCanvas.getWidth(),paintCanvas.getHeight(),BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,paintCanvas.getWidth(),paintCanvas.getHeight());
        for (InterfaceShape s: functionsOfShapes.getlistofShape()){
            s.draw(g);
            if(s.getShapeSize()>0){
                s.Childdrawn(g);
            }
        }
       g.dispose();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {

                ImageIO.write(image, "jpg", new File(file.getAbsolutePath()));
            } catch (Exception ex) {
                System.out.println("Failed to save image!");
            }
        } else {
            System.out.println("No file choosen!");
        }
    }

}
