package org.zhxie.chartDirector.ext;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ChartDirector.Chart;
import ChartDirector.ChartViewer;
import ChartDirector.ColorAxis;
import ChartDirector.ContourLayer;
import ChartDirector.XYChart;

public class DicreteHeatMap {

	
	public static void main(String[] args) {
		// Instantiate an instance of this demo module
		DicreteHeatMap demo = new DicreteHeatMap();

		// Create and set up the main window
		JFrame frame = new JFrame(demo.toString());
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().setBackground(Color.white);

		// Create the chart and put them in the content pane
		ChartViewer viewer = new ChartViewer();
		demo.createChart(viewer);
		frame.getContentPane().add(viewer);

		// Display the window
		frame.pack();
		frame.setVisible(true);
	}

	private void createChart(ChartViewer viewer) {
		int cellSize = 60;
		int xCount = 10;
		int yCount = 10;
		
		double[] dataZ = new double[100];
		
		int count = 0;
		for (int xIndex = 0; xIndex < 10; xIndex++) {
			for (int yIndex = 0; yIndex < 10; yIndex++) {
				dataZ[count] = Math.random() * 2.0;
				count++;
			}
		}
		
    XYChart c = new XYChart((xCount + 1) * cellSize + 180, (yCount + 1) * cellSize + 70);
    c.setPlotArea(50, 30, (xCount + 1) * cellSize, (yCount + 1) * cellSize, -1, -1, -1, Chart.Transparent, -1);
    c.xAxis().setLinearScale(620, 800, 20);
    c.yAxis().setLinearScale(620, 800, 20);
    c.xAxis().setMargin(cellSize, cellSize);
    c.yAxis().setMargin(cellSize, cellSize);
    c.xAxis().setLabelStyle("arialbd.ttf");
    c.yAxis().setLabelStyle("arialbd.ttf");

    // Create a dummy contour layer to use the color axis
    ContourLayer layer = c.addContourLayer(new double[] {}, new double[] {}, new double[] {});
		ColorAxis cAxis = layer.setColorAxis(c.getPlotArea().getRightX() + 30, c.getPlotArea().getTopY(), Chart.TopLeft,
		    c.getPlotArea().getHeight(), Chart.Right);
		double colors[] = { 0d, 0x00ae48, 1d,0xfdea83, 2d, 0xff4c4c };
		cAxis.setColorGradient(true);
		cAxis.setColorScale(colors);
		cAxis.setLinearScale(0, 2, 0.1);
		
		
		for (int xIndex = 0; xIndex < 10; xIndex++) {
			for (int yIndex = 0; yIndex < 10; yIndex++) {
				int index = xIndex * 10 + yIndex;
				int xWavelength = 620 + xIndex * 20;
				int yWavelength = 620 + yIndex * 20;
				if (xIndex + yIndex < 10) {
					int color = cAxis.getColor(dataZ[index]);
					c.addScatterLayer(new double[] { xWavelength }, new double[] { yWavelength }, "", Chart.SquareSymbol,
					    cellSize, color, color).addExtraField(new double[] { dataZ[index] });
				}
			}
		}
		
    viewer.setChart(c);
	}
}
