package buttonEvents;

import edu.neu.csye6200.students.view.DataView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class ExportClick implements ActionListener {
    private final DataView instance;
    public ExportClick(DataView view){
        this.instance = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("export Clicked");
        //new AddView(instance);
        //Classroom instance = Classroom.getInstance();
        //instance.printStudentsInformation();

    /*
     * Writes data from an input vector to a given file
     */

        PrintStream out = null;

        try {
            System.out.println("Start writing to file.");
            out = new PrintStream(new FileOutputStream("file.txt"));

            for (int i = 0; i < DataView.data.size(); i++)
                out.println(DataView.data.elementAt(i));
        } catch (ArrayIndexOutOfBoundsException e3) {
            System.err.println("ArrayIndexOutOfBoundsException Error:" +
                    e3.getMessage());
        } catch (IOException e2) {
            System.err.println("IOException: " + e2.getMessage());
        } finally {
            if (out != null) {
                System.out.println("PrintStream");
                out.close();
            } else {
                System.out.println("Couldn't open connection");
            }
        }

}

    public Vector fileToVector(String fileName) {
        Vector v = new Vector();
        String inputLine;
        try {
            File inFile = new File(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(inFile)));

            while ((inputLine = br.readLine()) != null) {
                v.addElement(inputLine.trim());
            }
            br.close();
        } // Try
        catch (FileNotFoundException ex) {
            //
        } catch (IOException ex) {
            //
        }
        return (v);
    }


}


