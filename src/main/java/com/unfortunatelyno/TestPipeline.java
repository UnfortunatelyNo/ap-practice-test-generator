package com.unfortunatelyno;

import java.util.Scanner;

public abstract class TestPipeline {
    // Standard AP Test Formats
    public static final Test AP_COMPUTER_SCIENCE_A = new Test("apcomputersciencea", 40, 90,
            new TopicArea[]{
                    new TopicArea(1, "Primitive Types",0.0375f),
                    new TopicArea(2, "Using Objects", 0.0625f),
                    new TopicArea(3, "Boolean Expressions and if Statements", 0.1625f),
                    new TopicArea(4, "Iteration",0.2f),
                    new TopicArea(5, "Writing Classes", 0.0625f),
                    new TopicArea(6, "Array", 0.125f),
                    new TopicArea(7, "ArrayList", 0.05f),
                    new TopicArea(8, "2D Array", 0.0875f),
                    new TopicArea(9, "Inheritance", 0.14f),
                    new TopicArea(10,"Recursion", 0.0625f)});
    public static final Test AP_PHYSICS_C_MECHANICS = new Test("apphysicscmechanics", 35, 45,
            new TopicArea[]{
                    new TopicArea(1, "Kinematics",0.17f),
                    new TopicArea(2, "Newton's Laws of Motion", 0.2f),
                    new TopicArea(3, "Work, Energy, Power", 0.155f),
                    new TopicArea(4, "Systems of Particles and Linear Momentum",0.155f),
                    new TopicArea(5, "Rotation", 0.17f),
                    new TopicArea(6, "Oscillations", 0.1f),
                    new TopicArea(7, "Gravitation", 0.1f)});
    public static final Test AP_CHEMISTRY = new Test("apchemistry", 60, 90,
            new TopicArea[]{
                    new TopicArea(1, "Atomic Structure and Properties",0.08f),
                    new TopicArea(2, "Molecular and Ionic Compound Structure and Properties", 0.08f),
                    new TopicArea(3, "Intermolecular Forces and Properties", 0.2f),
                    new TopicArea(4, "Chemical Reactions",0.08f),
                    new TopicArea(5, "Kinetics", 0.08f),
                    new TopicArea(6, "Thermodynamics", 0.08f),
                    new TopicArea(7, "Equilibrium", 0.08f),
                    new TopicArea(8, "Acids and Bases", 0.13f),
                    new TopicArea(9, "Applications of Thermodynamics", 0.08f)});
    public static final Test AP_WORLD_HISTORY = new Test("apworldhistory", 55, 55,
            new TopicArea[]{
                    new TopicArea(1, "The Global Tapestry",0.09f),
                    new TopicArea(2, "Networks of Exchange", 0.09f),
                    new TopicArea(3, "Land-Based Empires", 0.135f),
                    new TopicArea(4, "Transoceanic Interconnections",0.135f),
                    new TopicArea(5, "Revolutions", 0.135f),
                    new TopicArea(6, "Consequences of Industrialization", 0.135f),
                    new TopicArea(7, "Global Conflict", 0.09f),
                    new TopicArea(8, "Cold War and Decolonization", 0.09f),
                    new TopicArea(9, "Globalization", 0.09f)});
    public static final Test AP_US_GOVERNMENT_AND_POLITICS = new Test("apusgovernmentandpolitics", 55, 80,
            new TopicArea[]{
                    new TopicArea(1, "Foundations of American Democracy",0.185f),
                    new TopicArea(2, "Interactions Among Branches of Government", 0.305f),
                    new TopicArea(3, "Civil Liberties and Civil Rights", 0.155f),
                    new TopicArea(4, "American Political Ideologies and Beliefs",0.125f),
                    new TopicArea(5, "Political Participation", 0.235f)});
    public static final Test AP_COMPARATIVE_GOVERNMENT_AND_POLITICS = new Test("apcomparativegovernmentandpolitics", 55, 60,
            new TopicArea[]{
                    new TopicArea(1, "Political Systems, Regimes, and Governments",0.225f),
                    new TopicArea(2, "Political Institution", 0.275f),
                    new TopicArea(3, "Political Culture and Participation", 0.145f),
                    new TopicArea(4, "Party and Electoral Systems and Citizen Organizations",0.155f),
                    new TopicArea(5, "Political and Economic Changes and Development", 0.2f)});
    //public static final Test AP_BIOLOGY;
    // Processor Methods
    public static Test determineCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the course you would like a practice test for." +
                " No spaces or special characters (e.g. AP Physics C: Mechanics = \"apphysicscmechanics\")");
        String course = scanner.nextLine();

        if (AP_COMPUTER_SCIENCE_A.courseName.contains(course.toLowerCase())){
            return AP_COMPUTER_SCIENCE_A;
        }
        else if (AP_PHYSICS_C_MECHANICS.courseName.contains(course.toLowerCase())){
            return AP_PHYSICS_C_MECHANICS;
        }
        else if (AP_CHEMISTRY.courseName.contains(course.toLowerCase())){
            return AP_CHEMISTRY;
        }
        else if (AP_WORLD_HISTORY.courseName.contains(course.toLowerCase())){
            return AP_WORLD_HISTORY;
        }
        else if (AP_US_GOVERNMENT_AND_POLITICS.courseName.contains(course.toLowerCase())){
            return AP_US_GOVERNMENT_AND_POLITICS;
        }
        else if (AP_COMPARATIVE_GOVERNMENT_AND_POLITICS.courseName.contains(course.toLowerCase())){
            return AP_COMPARATIVE_GOVERNMENT_AND_POLITICS;
        }
        else{
            System.out.println("No courses found, please try again");
            return determineCourse();
        }
    }
    public static Test determineFormat(Test t, int maxQs){
        byte customFormat = 0; // 0 indicates not selected, 1 indicates custom, 2 indicates pre-made,
        // 3 indicates custom past choosing number of questions, 4 indicates past custom weighting
        Scanner scanner = new Scanner(System.in);
        Test t_n = t;
        while (customFormat == 0){
            System.out.println("Please input the format you would like a practice test for." +
                " Type \"custom\", \"apStandard\", \"allProb\", or \"explain\" for an explanation");
            String input = scanner.nextLine();
            if (input.equals("custom")){
                customFormat = 1;
                t_n = new Test(t.courseName, t.numQuestions, t.time, t.topics);
            }
            else if (input.equals("apStandard")){
                return t_n;
            }
            else if (input.equals("allProb")){
                t_n.numQuestions = maxQs;
                return t_n;
            }
            else {
                System.out.println("\"custom\" allows you to format the test in three ways: number of questions," +
                        " inclusion of subtopics, and weighting of subtopics. NOTE: The last two may or may not" +
                        " be available depending on the course.");
                System.out.println("\"apStandard\" assumes the format of the regular ap exam of your chosen" +
                        " course including number of questions and standard subtopic weighting found on the" +
                        " AP Course and Exam Description for your chosen course");
                System.out.println("\"allProb\" will include every multiple choice question available in the bank");
            }
        }
        while (customFormat != 2) {
            System.out.println("Please input the amount of questions you would like, the " +
                    "AP Standard is " + t.numQuestions + ". The amount of questions " +
                    "in the bank is " + maxQs);
            int i = scanner.nextInt();
            if (i <= maxQs) {
                t_n.numQuestions = i;
                customFormat = 2;
            }
            else {
                System.out.println("Not enough questions in the bank. Please choose a value " +
                        "less than or equal to " + maxQs);
            }
        }
        while (customFormat != 3) {
            System.out.println("Please type \"custom\" for custom weighting, or type \"apWeight\"" +
                    " for regular AP weighting.");
            String input2 = scanner.nextLine();
            if (input2.equals("custom")) {
                System.out.println("Please make sure that the sum of these values is 1 (e.g. " +
                        "17% -> 0.17) or the test will not contain the correct amount of questions" +
                        ". If you do not want a topic included type 0.");
                for (TopicArea topic : t_n.topics){
                    System.out.println(topic);
                    topic.weight = scanner.nextFloat();
                }
                customFormat = 3;
            }
            else if (input2.equals("apWeight")){
                System.out.println("AP Weighting Chosen");
                customFormat = 3;
            }
            else{
                System.out.println("Not valid weight");
            }
        }
        return t_n;
    }
}
