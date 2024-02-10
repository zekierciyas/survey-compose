# Survey View 
[![](https://jitpack.io/v/zekierciyas/survey-compose.svg)](https://jitpack.io/#zekierciyas/survey-compose)

Android library written in Jetpack Compose, containing a fully configurable survey/questionnaire screen.

<img src="/previews/preview_video.gif" align="center" height="660"/>

## Gradle

**Step 1** : Add the JitPack repository to your build file

```gradle
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2** : Add the dependency


```gradle
implementation 'com.github.zekierciyas:survey-compose:1.0.0'
```

## Usage

<img src="/previews/preview_image.jpg" align="right" height="660"/>


``` kotlin
@Composable
fun SurveyView() {

    var showMessage by remember { mutableStateOf(false) }

    val sampleSurvey = listOf(
        SurveyModel(
            questionType = QuestionType.MULTIPLE_CHOICE,
            questionId = "id1",
            questionTitle = "1) Select your favorite color:",
            answers = listOf("Red", "Green", "Blue"),
            questionDescription = "Description"
        ),
        SurveyModel(
            questionType = QuestionType.SINGLE_CHOICE,
            questionId ="id2",
            questionTitle ="2) Choose your preferred programming language:",
            answers = listOf("Java", "Kotlin", "Swift", "Python"),
            questionDescription = "Description"
        ),
        SurveyModel(
            questionType = QuestionType.TEXT,
            questionId ="id3",
            questionTitle ="3) Choose your preferred programming language:",
            questionDescription = "Description"
        )
    )
    SurveyScreen(
        survey = sampleSurvey,
        backgroundColor = Color.White,
        singleOptionUI = SingleOptionUI(
            questionTitle = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold
            ),
            answer = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            ),
            selectedColor = Color.White,
            unSelectedColor = Color.Gray,
            borderColor = Color.Gray
        ),
        multipleOptionUI = MultipleOptionUI(
            questionTitle = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold
            ),
            answer = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            ),
            checkedColor = Color.Gray,
            uncheckedColor = Color.White,
            borderColor = Color.Gray
        ),
        textOptionUI = TextOptionUI(
            questionTitle = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold
            ),
            answer = SurveyText(
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            ),
            borderColor = Color.Gray,
            backgroundColor = Color.White,
            surveyOutlinedText = SurveyOutlinedText(
                focusedTextColor = Color.DarkGray,
                unfocusedContainerColor = Color.White,
                focuedLabelColor = Color.DarkGray
            )
        ),
        callbackAnswers =  {

        },
        callbackAllAnswered = {
            showMessage = true
        })

    if (showMessage) {
        Snackbar(
            action = {
                Button(
                    onClick = { showMessage = false }
                ) {
                    Text("Dismiss")
                }
            }
        ) {
            Text(text = "All questions are done")
        }
    }
}
```        
