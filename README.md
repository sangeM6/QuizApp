# Life Hack or Urban Myth Application Report

## Description
This android Application was built using Kotlin and Jetpack Compose. The app challenges the user to answer whether the provided statement is 
true(Life Hack) or false (Urban Myth), gives a quick feedback, tracks the user's score, and allows the user to review all questions with their 
correct answers and retry if failed.

## Purpose of the Application
The purpose of this app is to test users common sense, help them differentiate between real life hacks and urban myths, and teach useful real-world
shortcuts.

## Features
- True or False questions on life hacks and urban myths.
- Provides a quick feedback after each answer.
- Tracks score
- Question progress indicator (e.g. 4 of 10).
- Review all the questions with their correct answers.
- Next Button is disabled until the user answers a question (this prevents the user from skipping questions)
- Provides a simple and clean user interface.

## Design Consideration
This application was designed to simple, easy to use, and easy to understand. It provides clear questions and button to help guide the user when or
while using the app. Provides a quick feedback when the true or false button is clicked.

## Technology Used
1. Kotlin
2. Android Studio
3. Jetpack Compose

## Code Example
 Text(
      text = "${index + 1} of ${questions.size}",
      fontSize = 18.sp,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center
  ) This line of code is the progress indicator, each question number is stored in index and when the user goes to the next question value 1 is added 
  to the index (e.g if index has 1 and the user goes to the next question, 1 is added to the existing 1 and the new value is 2

  ## Screenshot
  ![Quiz App Home Page](drawable/homepage.png)
  ![Quiz Questions](drawable/quizquestions.png)
  ![Quiz Feedback](drawable/quizfeedback.png)

  ## Video
  [Watch App Video](https://youtu.be/YP1flvIj7rg)

  ## GitHub Usage
  GitHub was used to store and save the project online and track changes made. Commits were also made to save progress and for someone veiwing 
  the code to see changes made or added information and also not get confused.

  ## GitHub Actions
  GitHub Actions were used to check for failures, successes or errors of the code. Created a workflow to run when code is pushed, helping to check if the project buid successfully.

  ## To Run The Application
  * Open the project in Android Studio
  * Run the app on the emulator or Android device

  ## Author
  ZUSANGE MBALEKI

  ## References
Android Developers, 2025. *Create a button* [online]. Available at: https://developer.android.com/develop/ui/compose/quick-guides/content/create-button (Accessed on: 28 April 2026).
Android Developers, 2025. *State and Jetpack Compose* [online]. Available at: https://developer.android.com/develop/ui/compose/state (Accessed on: 28 April 2026).
Android Developers, 2025. *Card* [online]. Available at: https://developer.android.com/develop/ui/compose/components/card (Accessed on: 30 April 2026).
Android Developers, 2025. *Brush: Gradients and Shaders* [online]. Available at: https://developer.android.com/develop/ui/compose/graphics/draw/brush (Accessed on: 30 April 2026).
Kaval G., 2022. *Jetpack Compose Theming: Colors* [online]. Available at: https://medium.com/better-programming/jetpack-compose-theming-colors-1cf86754d5b9 (Accessed on: 30 April 2026).
