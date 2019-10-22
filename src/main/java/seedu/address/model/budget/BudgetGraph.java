package seedu.address.model.budget;

import java.awt.Color;
import java.awt.BasicStroke;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import seedu.address.model.claim.Claim;
import seedu.address.model.income.Income;

import javax.swing.*;

public class BudgetGraph extends JFrame {

    private List<Claim> claimList;
    private List<Income> incomeList;

    public BudgetGraph(List<Claim> claimList,List<Income> incomeList) {
        this.claimList = claimList;
        this.incomeList = incomeList;
    }

    private BudgetGraph(String applicationTitle, String chartTitle, List<Claim> claimList,List<Income> incomeList) {
        super(applicationTitle);
        JFreeChart xyLineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Time (Days)" ,
                "Money ($)" ,
                createDataSet(claimList, incomeList) ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xyLineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xyLineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
        renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        XYToolTipGenerator xyToolTipGenerator = (dataSet, series, item) -> {
            Number x1 = dataSet.getX(series, item);
            Number y1 = dataSet.getY(series, item);
            return String.format("<html><p style='color:#0000ff;'>Series: '%s'</p>",
                    dataSet.getSeriesKey(series)) +
                    String.format("Time: Day %d<br/>", x1.intValue()) +
                    String.format("Money: $%.2f", y1.doubleValue()) +
                    "</html>";
        };
        renderer.setBaseToolTipGenerator(xyToolTipGenerator);
    }

    private XYDataset createDataSet(List<Claim> claimList,List<Income> incomeList) {
        final XYSeries claim = new XYSeries( "Claim" );
        ClaimPlotter claimPlotter = new ClaimPlotter(claimList, claim);

        final XYSeries income = new XYSeries( "Income" );
        income.add( 1.0 , 133 );
        income.add( 2.0 , 222 );
        income.add( 3.0 , 555.55 );

        final XYSeries budget = new XYSeries( "Budget" );
        budget.add( 3.0 , 4.0 );
        budget.add( 4.0 , 5.0 );
        budget.add( 5.0 , 4.0 );

        final XYSeriesCollection dataSet = new XYSeriesCollection( );
        dataSet.addSeries(claimPlotter.plotClaims());
        dataSet.addSeries( income );
        dataSet.addSeries( budget );
        return dataSet;
    }

    public void displayBudgetGraph(){
        BudgetGraph chart = new BudgetGraph("Budget Statistics",
                "Statistics for current Month", claimList, incomeList);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
        chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}