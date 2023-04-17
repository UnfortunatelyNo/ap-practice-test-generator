package com.unfortunatelyno;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

/*
Copyright 2023 The Apache Software Foundation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        // TO DO: Follow article to appropriately fit text in a not dumb way
        MCAnswer testAnswer = new MCAnswer('A', "Momentum Vector");
        MCQuestion testQuestion = new MCQuestion("What kind of vector?", "velocity", "momentum",
                "acceleration", "force", "speed", 'A');
        /*
        System.out.println(testAnswer);
        System.out.println(testQuestion);
        System.out.println(TestPipeline.AP_PHYSICS_C_MECHANICS);
        final int margin = 75;
         */
        Test testTest = new Test();
        testTest = TestPipeline.determineCourse();
        testTest = TestPipeline.determineFormat(testTest, 100);
        System.out.println(testTest);
        System.out.println(testTest.numQuestions);
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50,500);
        contentStream.setLeading(50f);
        contentStream.showText(testQuestion.toString());
        contentStream.endText();
        contentStream.close();

        document.save("pdfBoxHelloWorld.pdf");
        document.close();


    }
}