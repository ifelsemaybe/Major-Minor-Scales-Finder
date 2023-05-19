package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Major_Minor_Scales {

    public static void main(String[] args) {

        for (int i1 = 0; i1 >= 0; i1++) {

            int record = 0;

            String orange_bold_underlined = "\033[1;4;38;2;255;153;51m";
            String reset = "\033[0m";

            String answer = "";
            String scale = "";
            String[] notes = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
            String[] notesWithSmallCaps = {"A", "a", "A#", "a#", "B", "b", "C", "c", "C#", "c#", "D", "d", "D#", "d#", "E", "e", "F", "f", "F#", "f#", "G", "g", "G#", "g#"};

            String[] major = {"whole-step", "whole-step", "half-step", "whole-step", "whole-step", "whole-step", "half-step"};
            String[] minor = {"whole-step", "half-step", "whole-step", "whole-step", "half-step", "whole-step", "whole-step"};

            String[] scaled = new String[8];

            Scanner dardar = new Scanner(System.in);

            for (int i = 0; i >= 0; i++) {

                System.out.print("\nWhat is your root note? : ");
                answer = dardar.next();
                System.out.println();

                if(Objects.equals(answer, "exit") || Objects.equals(answer, "0") ){

                    System.out.println("Exiting!");
                    dardar.close();

                    System.exit(0);

                }

                if (!(Arrays.asList(notesWithSmallCaps).contains(answer))) {

                    System.out.println("Sorry, but you have to input one of the 12 musical notes! Try again...\n");

                } else {

                    break;
                }

            }


            for (int i = 0; i >= 0; i++) {

                System.out.print("Are you looking for the major or minor scale? : ");
                scale = dardar.next();
                System.out.println();

                if (!(Arrays.asList("major", "Major", "minor", "Minor", "M", "m")).contains(scale)) {

                    System.out.println("Sorry, but you have to input the major or minor scale (M or m)! Try again...\n");
                } else {

                    break;
                }
            }


            if (scale.equalsIgnoreCase("major") || scale.equals("M")) {

                for (int i = 0; i < 12; i++) {

                    if (answer.equalsIgnoreCase(notes[i])) {

                        record = i;
                        break;

                    }

                }


                scaled[0] = notes[record];

                for (int i = 0; i < 7; i++) {

                    if (major[i].equals("half-step")) {

                        record++;
                        scaled[i + 1] = notes[record];
                    }

                    if (major[i].equals("whole-step")) {

                        record = record + 2;

                        scaled[i + 1] = notes[record];
                    }
                }

            }

            if (scale.equalsIgnoreCase("minor") || scale.equals("m")) {

                for (int i = 0; i < 12; i++) {

                    if (answer.equalsIgnoreCase(notes[i])) {

                        record = i;
                        break;

                    }

                }


                scaled[0] = notes[record];

                for (int i = 0; i < 7; i++) {

                    if (minor[i].equals("half-step")) {

                        record++;
                        scaled[i + 1] = notes[record];
                    }

                    if (minor[i].equals("whole-step")) {

                        record = record + 2;

                        scaled[i + 1] = notes[record];
                    }
                }


            }

            System.out.println("Your notes are: \n");

            for (int i = 0; i < 8; i++) {

                if (i == 0) {

                    System.out.print(orange_bold_underlined + scaled[i] + reset + " ");
                } else {

                    System.out.print(scaled[i] + " ");

                }

            }

            System.out.println();

        }
    }

}
