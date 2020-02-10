
import java.io.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Grade Book Program Starter Code
 * November 12, 2018
 * Jessica Zheng
 * A program to store students' names and marks. 
 */
public class GradesFrm extends javax.swing.JFrame {

    //2D array to hold up to 50 students (first and last) and their grades in 4 courses
    String[][] grades = new String[50][6];
    int numStud = 0; //keep track of number of Students currently in array

    //Variables that hold the input in Strings
    String stringFName = "";
    String stringLName = "";

    String stringCourseOneInput = "";
    String stringCourseTwoInput = "";
    String stringCourseThreeInput = "";
    String stringCourseFourInput = "";

    //Variables that hold the course input in doubles
    //Gets converted from String to double
    double doubleCourseOne = 0;
    double doubleCourseTwo = 0;
    double doubleCourseThree = 0;
    double doubleCourseFour = 0;

    //Student average number, set to 0 until calculations
    double studentAverage = 0;

    //created and initialized sum course values to 0
    double sumCourseOne = 0;
    double sumCourseTwo = 0;
    double sumCourseThree = 0;
    double sumCourseFour = 0;
    //checks to see if it is valid, if not it will not run the if statements
    boolean check = true;
    int num;

    //checks if the student is already there before importing
    private boolean checkStudentImport(String firstName, String lastName) {

        for (int i = 0; i < numStud; i++) {
            if (grades[i][0].equalsIgnoreCase(firstName)
                    && grades[i][1].equalsIgnoreCase(lastName)) {
                return true;
            }
        }
        return false;
    }

    //methods to generate error messages
    private void fillInBoxesMessage() {
        //when user has not filled all the boxes
        JOptionPane.showMessageDialog(this,
                "Fill in all the boxes.", "Oops", JOptionPane.ERROR_MESSAGE);
        check = false;
    }

    private void incorrectCoursePercent() {
        //when user puts an invalid mark
        JOptionPane.showMessageDialog(this,
                "You cannot have over 100% in a course or under 0%.", "Oops", JOptionPane.ERROR_MESSAGE);
        check = false;
    }

    //method to check if the mark is appropriate
    private void check() {
        try {
            if (Double.parseDouble(stringCourseOneInput) > 100 || Double.parseDouble(stringCourseOneInput) < 0) {
                incorrectCoursePercent();
            } else if (Double.parseDouble(stringCourseTwoInput) > 100 || Double.parseDouble(stringCourseTwoInput) < 0) {
                incorrectCoursePercent();
            } else if (Double.parseDouble(stringCourseThreeInput) > 100 || Double.parseDouble(stringCourseThreeInput) < 0) {
                incorrectCoursePercent();
            } else if (Double.parseDouble(stringCourseFourInput) > 100 || Double.parseDouble(stringCourseFourInput) < 0) {
                incorrectCoursePercent();
            }
        } catch (NumberFormatException e) { //catches when user does not put a number in the input boxes
            JOptionPane.showMessageDialog(this,
                    //displays an error message
                    "Please put a number for the course mark.", "Oops", JOptionPane.ERROR_MESSAGE);
            check = false;
        }

    }

    //accepts a 2D array and number of students
    //calculates the course averages
    private void courseAverages(String[][] grades) {

        for (int i = 0; i < numStud; i++) {
            //adds all the course 1 marks together
            sumCourseOne += Double.parseDouble(grades[i][2]);
        }
        sumCourseOne /= numStud; //divides by number of students

        for (int i = 0; i < numStud; i++) {
            //adds all the course 2 marks together
            sumCourseTwo += Double.parseDouble(grades[i][3]);
        }
        sumCourseTwo /= numStud; //divides by number of students

        for (int i = 0; i < numStud; i++) {
            //adds all the course 3 marks together
            sumCourseThree += Double.parseDouble(grades[i][4]);
        }
        sumCourseThree /= numStud; //divides by number of students

        for (int i = 0; i < numStud; i++) {
            //adds all the course 4 marks together
            sumCourseFour += Double.parseDouble(grades[i][5]);
        }
        sumCourseFour /= numStud; //divides by number of students
        //displays the course averages in the textbox
        displayArea.setText("Course 1 Average: " + String.format("%.2f", sumCourseOne) + "%"
                + "\nCourse 2 Average: " + String.format("%.2f", sumCourseTwo) + "%"
                + "\nCourse 3 Average: " + String.format("%.2f", sumCourseThree) + "%"
                + "\nCourse 4 Average: " + String.format("%.2f", sumCourseFour) + "%");
        //sets course sums back to 0 incase students get deleted
        sumCourseOne = 0;
        sumCourseTwo = 0;
        sumCourseThree = 0;
        sumCourseFour = 0;

    }

    //receives the text and sets it to the variables as a String
    private void getCourseMarks() {
        stringCourseOneInput = course1In.getText();
        stringCourseTwoInput = course2In.getText();
        stringCourseThreeInput = course3In.getText();
        stringCourseFourInput = course4In.getText();
    }

    //sets all textfields to an empty cell
    private void blank() {
        fNameInput.setText("");
        lNameInput.setText("");
        course1In.setText("");
        course2In.setText("");
        course3In.setText("");
        course4In.setText("");
    }

    /**
     * Creates new form GradesFrm
     */
    public GradesFrm() {
        initComponents();
        //textbox is not able to edit by users
        displayArea.setEditable(false);
        //delete button set to false until user finds student
       
       

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        fNameLbl = new javax.swing.JLabel();
        fNameInput = new javax.swing.JTextField();
        lNameLbl = new javax.swing.JLabel();
        lNameInput = new javax.swing.JTextField();
        reportArea = new javax.swing.JScrollPane();
        displayArea = new javax.swing.JTextArea();
        course1Lbl = new javax.swing.JLabel();
        course1In = new javax.swing.JTextField();
        course2Lbl = new javax.swing.JLabel();
        course2In = new javax.swing.JTextField();
        course4Lbl = new javax.swing.JLabel();
        course4In = new javax.swing.JTextField();
        course1Lbl3 = new javax.swing.JLabel();
        course3In = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        ListBtn = new javax.swing.JButton();
        studAvgBtn = new javax.swing.JButton();
        courseAvgBtn = new javax.swing.JButton();
        importBtn = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        findBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("Grade Book 1.0");
        titleLbl.setFocusable(false);

        fNameLbl.setLabelFor(fNameInput);
        fNameLbl.setText("First name:");
        fNameLbl.setFocusable(false);

        fNameInput.setNextFocusableComponent(lNameInput);
        fNameInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fNameInputMouseEntered(evt);
            }
        });

        lNameLbl.setLabelFor(lNameInput);
        lNameLbl.setText("Last name:");
        lNameLbl.setFocusable(false);

        lNameInput.setNextFocusableComponent(course1In);
        lNameInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lNameInputMouseEntered(evt);
            }
        });

        reportArea.setFocusable(false);

        displayArea.setColumns(20);
        displayArea.setRows(5);
        reportArea.setViewportView(displayArea);

        course1Lbl.setLabelFor(course1In);
        course1Lbl.setText("Course 1:");
        course1Lbl.setFocusable(false);

        course1In.setNextFocusableComponent(course2In);
        course1In.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course1InMouseEntered(evt);
            }
        });

        course2Lbl.setLabelFor(course2In);
        course2Lbl.setText("Course 2:");
        course2Lbl.setFocusable(false);

        course2In.setNextFocusableComponent(course3In);
        course2In.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course2InMouseEntered(evt);
            }
        });

        course4Lbl.setLabelFor(course4In);
        course4Lbl.setText("Course 4:");
        course4Lbl.setToolTipText("");
        course4Lbl.setFocusable(false);

        course4In.setNextFocusableComponent(addBtn);
        course4In.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course4InMouseEntered(evt);
            }
        });

        course1Lbl3.setLabelFor(course3In);
        course1Lbl3.setText("Course 3:");
        course1Lbl3.setInheritsPopupMenu(false);

        course3In.setNextFocusableComponent(course4In);
        course3In.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                course3InMouseEntered(evt);
            }
        });

        addBtn.setText("Add Student");
        addBtn.setNextFocusableComponent(ListBtn);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        ListBtn.setText("List All");
        ListBtn.setNextFocusableComponent(studAvgBtn);
        ListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListBtnActionPerformed(evt);
            }
        });

        studAvgBtn.setText("Student Average");
        studAvgBtn.setNextFocusableComponent(courseAvgBtn);
        studAvgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studAvgBtnActionPerformed(evt);
            }
        });

        courseAvgBtn.setText("Course Averages");
        courseAvgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseAvgBtnActionPerformed(evt);
            }
        });

        importBtn.setText("Import Student List");
        importBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBtnActionPerformed(evt);
            }
        });

        exportBtn.setText("Export Data to File");
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        findBtn.setText("Find Student");
        findBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete Student");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(reportArea, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(course1Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(course2Lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(course1Lbl3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(course4Lbl, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(course4In, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(course1In, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(course2In, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(course3In, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(studAvgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(findBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ListBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(courseAvgBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fNameLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(lNameLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(importBtn)
                .addGap(99, 99, 99)
                .addComponent(exportBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLbl)
                    .addComponent(fNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNameLbl)
                    .addComponent(lNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(course1Lbl)
                            .addComponent(course1In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(course2Lbl)
                            .addComponent(course2In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ListBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(course1Lbl3)
                            .addComponent(course3In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(findBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course4Lbl)
                    .addComponent(course4In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studAvgBtn)
                    .addComponent(courseAvgBtn))
                .addGap(44, 44, 44)
                .addComponent(reportArea, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importBtn)
                    .addComponent(exportBtn))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //adds students with the information that was inputted by user

    private void addStudent(String first, String last, String c1, String c2, String c3, String c4) {

        numStud++; //add one to the number of students stored in array
        int i = numStud - 1; //determine the index of where to add the new student
        //sets the information to the array value
        grades[i][0] = first;
        grades[i][1] = last;
        grades[i][2] = c1;
        grades[i][3] = c2;
        grades[i][4] = c3;
        grades[i][5] = c4;

        //print 'added' to the command line and displays name and course marks
//        System.out.println("\nAdded");
//        for (int x = 0; x < 6; x++) {
//            System.out.print(grades[i][x] + " ");
//        }
        //sets values to blank
        blank();

    }
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        //check initialized to true
        check = true;
        //receives input from all 6 fields (names and 4 courses)
        stringFName = fNameInput.getText().trim();
        stringLName = lNameInput.getText().trim();
        getCourseMarks();
        //if any are empty return an error message
        if (stringFName.isEmpty() || stringLName.isEmpty() || stringCourseOneInput.isEmpty()
                || stringCourseTwoInput.isEmpty() || stringCourseThreeInput.isEmpty()
                || stringCourseFourInput.isEmpty()) {
            fillInBoxesMessage();
            return;
        }
        //check each student if the name has already been inputted
        for (int i = 0; i < numStud; i++) {
            if (grades[i][0].equalsIgnoreCase(stringFName)
                    && grades[i][1].equalsIgnoreCase(stringLName)) {
                //prints an error message
                JOptionPane.showMessageDialog(this,
                        "That student is already added.", "Oops", JOptionPane.ERROR_MESSAGE);
                //check set to false therefore it will not run other if statments
                check = false;
            }
        }
        //check is true therefore student can be added
        if (check) {
            //the student count has to be under 50 
            if (numStud < 50) {
                //checks if course inputs are a double
                check();
                //check is true, adds each of the values to the array
                if (check) {
                    addStudent(stringFName, stringLName, stringCourseOneInput, stringCourseTwoInput, stringCourseThreeInput, stringCourseFourInput);
                    courseAvgBtn.setVisible(true); //course average button is visible
                    displayArea.setText(stringFName + " " + stringLName + " added.");
                }
            } else if (numStud >= 50) { //greater than 50 students will force an error message
                JOptionPane.showMessageDialog(this,
                        "Too many students, cannot add another student.", "Oops", JOptionPane.ERROR_MESSAGE);
                blank(); //textboxes are empty

            }
        }
        

    }//GEN-LAST:event_addBtnActionPerformed

    private void ListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListBtnActionPerformed

        //no students to the list, will not print list of students
        if (numStud == 0) {
            displayArea.setText("No students to list.");
            return;
        }
        //displays students names and marks in chart format
        displayArea.setText("First Name\tLast Name \tC1 \tC2 \tC3 \tC4 \n");
        for (int i = 0; i < numStud; i++) {
            for (int j = 0; j < 6; j++) {
                displayArea.setText(displayArea.getText() + grades[i][j] + "\t");
            }
            displayArea.setText(displayArea.getText() + "\n");
        }
        blank(); //textboxes are empty
        
    }//GEN-LAST:event_ListBtnActionPerformed

    private void studAvgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studAvgBtnActionPerformed
        check = true;
        //receives names from input
        stringFName = fNameInput.getText().trim();
        stringLName = lNameInput.getText().trim();
        //receives the course marks
        getCourseMarks();
        //if all of the course input boxes are filled changes course marks to doubles
        check();
        if (check) {
            if (!stringFName.equals("") && !stringLName.equals("") && !stringCourseOneInput.equals("") && !stringCourseTwoInput.equals("")
                    && !stringCourseThreeInput.equals("") && !stringCourseFourInput.equals("")) {
                //System.out.println("hello");
                doubleCourseOne = Double.parseDouble(stringCourseOneInput);
                doubleCourseTwo = Double.parseDouble(stringCourseTwoInput);
                doubleCourseThree = Double.parseDouble(stringCourseThreeInput);
                doubleCourseFour = Double.parseDouble(stringCourseFourInput);
                //adds all of them up and divides by 4
                studentAverage = (doubleCourseOne + doubleCourseTwo + doubleCourseThree + doubleCourseFour) / 4;
                //displays the students name and average
                displayArea.setText(fNameInput.getText() + " " + lNameInput.getText() + " has an average of " + studentAverage + "%");
            } else {
                //error message pops up when everything is not filled in
                fillInBoxesMessage();
            }
        }
        
    }//GEN-LAST:event_studAvgBtnActionPerformed

    private void courseAvgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseAvgBtnActionPerformed
        if (numStud == 0) {
            displayArea.setText("No students exist. No course average.");
            return;
        }
        //figures out the course averages for each of the four classes
        courseAverages(grades);
        blank(); //textboxes are empty
        
    }//GEN-LAST:event_courseAvgBtnActionPerformed

    private void importBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBtnActionPerformed
        
        //adds data from the gradebook1.txt file
        try {
            FileReader fr = new FileReader("gradebook1.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            line = br.readLine(); // read first line
            displayArea.setText("");
            while (line != null) {
                //split the line of input into an array of strings 
                // the "\\s" splits on a space
                String[] temp = line.split("\\s");
                if (numStud >= 50) {
                    displayArea.append("Already reached 50 students.");
                    break;
                }
                //checks if the person is already there
                if (!checkStudentImport(temp[0], temp[1])) {
                    //call addStudent method to put student into array
                    addStudent(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
                    displayArea.append(temp[0] + " " + temp[1] + " added.\n");
                } else {
//                        System.out.println("Could not import " + temp[0] + " "+ temp[1] + " student, "
//                                + "they already exist.");
                    displayArea.append("Could not import " + temp[0] + " " + temp[1] + " student, "
                            + "they already exist.\n");
                }

                line = br.readLine(); //reads the next cost before starting loop again
            }
            br.close();
        } catch (IOException e) {
            //don't need message, just stop from crashing  
            //System.out.println("Import Failed");
        }
        //course average button is visible
        courseAvgBtn.setVisible(true);
        blank(); //textboxes are empty
        

    }//GEN-LAST:event_importBtnActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        //no students, error message will pop up
        if (numStud == 0) {
            JOptionPane.showMessageDialog(this,
                    "Nothing to export", "Oops", JOptionPane.ERROR_MESSAGE);
            blank();
            return;
        }
        try {
            File gradebook = new File("gradebook1.txt");
            gradebook.delete();
            FileWriter fw = new FileWriter(gradebook);
            BufferedWriter bw = new BufferedWriter(fw);
            //adds all grades and names to file
            for (int i = 0; i < numStud; i++) {
                bw.append(String.format("%s %s %s %s %s %s\n",
                        grades[i][0],
                        grades[i][1],
                        grades[i][2],
                        grades[i][3],
                        grades[i][4],
                        grades[i][5]));
            }

            bw.close();
        } catch (IOException e) {
            //don't need message, just stop from crashing  
            //System.out.println("Export Failed");
        }
        blank(); //textboxes are empty
        
    }//GEN-LAST:event_exportBtnActionPerformed

    private void findBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBtnActionPerformed
        //gets the first and last name 
        stringFName = fNameInput.getText().trim();
        stringLName = lNameInput.getText().trim();
        check = true;
        //first and last name must be filled in 
        if (stringFName.isEmpty() || stringLName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Fill in both first and last name boxes.", "Oops", JOptionPane.ERROR_MESSAGE);
            check = false;
            return;
        }
        //searches through the array if the first and last name are the same
        for (int i = 0; i < numStud; i++) {
            if (grades[i][0].equalsIgnoreCase(stringFName)
                    && grades[i][1].equalsIgnoreCase(stringLName)) {
                //finds their grades and sets them in the course boxes
                //sets their first name and last name as inputted
                fNameInput.setText(grades[i][0]);
                lNameInput.setText(grades[i][1]);
                course1In.setText(grades[i][2]);
                course2In.setText(grades[i][3]);
                course3In.setText(grades[i][4]);
                course4In.setText(grades[i][5]);
                check = false;
                num = i;
                
            }
        }
        //check remains true, then error message pops up
        if (check) {
            JOptionPane.showMessageDialog(this,
                    "Cannot find student", "Oops", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_findBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        stringFName = fNameInput.getText().trim();
        stringLName = lNameInput.getText().trim();
        //find a student before deleting a student
        if(!checkStudentImport(stringFName, stringFName)) {
            JOptionPane.showMessageDialog(this,
                    "Cannot delete, student doesn't exist", "Oops", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        for (int i = 0; i < numStud; i++) {
            if (grades[i][0].equalsIgnoreCase(stringFName)
                    && grades[i][1].equalsIgnoreCase(stringLName)) {
                //finds their grades and sets them in the course boxes
                //sets their first name and last name as inputted
                fNameInput.setText(grades[i][0]);
                lNameInput.setText(grades[i][1]);
                course1In.setText(grades[i][2]);
                course2In.setText(grades[i][3]);
                course3In.setText(grades[i][4]);
                course4In.setText(grades[i][5]);
                check = false;
                num = i;
                
            }
        }
        
      
        displayArea.setText(grades[num][0] + " " + grades[num][1] + " removed.");
        //sets the student that is being deleted to null
        grades[num][0] = null;
        grades[num][1] = null;
        grades[num][2] = null;
        grades[num][3] = null;
        grades[num][4] = null;
        grades[num][5] = null;

        //sets the student spot to fill the last inputted name
        //moves the last person to that spot
        grades[num][0] = grades[numStud - 1][0];
        grades[num][1] = grades[numStud - 1][1];
        grades[num][2] = grades[numStud - 1][2];
        grades[num][3] = grades[numStud - 1][3];
        grades[num][4] = grades[numStud - 1][4];
        grades[num][5] = grades[numStud - 1][5];

        //sets the student spot of the last person to nothing 
        grades[numStud - 1][0] = null;
        grades[numStud - 1][1] = null;
        grades[numStud - 1][2] = null;
        grades[numStud - 1][3] = null;
        grades[numStud - 1][4] = null;
        grades[numStud - 1][5] = null;

        //the students inputted decreases
        numStud--;
//            System.out.println(numStud);
        blank(); //textboxes are empty
            

        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void fNameInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fNameInputMouseEntered
        fNameInput.requestFocus(); //allows mouse to hover over it and input immediately
    }//GEN-LAST:event_fNameInputMouseEntered

    private void lNameInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lNameInputMouseEntered
        lNameInput.requestFocus(); //allows mouse to hover over it and input immediately
    }//GEN-LAST:event_lNameInputMouseEntered

    private void course1InMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course1InMouseEntered
        course1In.requestFocus(); //allows mouse to hover over it and input immediately
    }//GEN-LAST:event_course1InMouseEntered

    private void course2InMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course2InMouseEntered
        course2In.requestFocus(); //allows mouse to hover over it and input immediately
    }//GEN-LAST:event_course2InMouseEntered

    private void course3InMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course3InMouseEntered
        course3In.requestFocus(); //allows mouse to hover over it and input immediately
    }//GEN-LAST:event_course3InMouseEntered

    private void course4InMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course4InMouseEntered
        course4In.requestFocus(); //allows mouse to hover over it and input immediately
    }//GEN-LAST:event_course4InMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GradesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradesFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ListBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField course1In;
    private javax.swing.JLabel course1Lbl;
    private javax.swing.JLabel course1Lbl3;
    private javax.swing.JTextField course2In;
    private javax.swing.JLabel course2Lbl;
    private javax.swing.JTextField course3In;
    private javax.swing.JTextField course4In;
    private javax.swing.JLabel course4Lbl;
    private javax.swing.JButton courseAvgBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea displayArea;
    private javax.swing.JButton exportBtn;
    private javax.swing.JTextField fNameInput;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JButton findBtn;
    private javax.swing.JButton importBtn;
    private javax.swing.JTextField lNameInput;
    private javax.swing.JLabel lNameLbl;
    private javax.swing.JScrollPane reportArea;
    private javax.swing.JButton studAvgBtn;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
