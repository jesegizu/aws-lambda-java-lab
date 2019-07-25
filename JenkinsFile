pipeline {
  agent any
   environment {
     projectName = 'tns-devops-juanes'
     packageName = "lambdaGradle-${BUILD_NUMBER}.zip"
   }
  stages {
    stage('Build') {
          post{
            always{
              archiveArtifacts(artifacts: "build/distributions/${packageName}", fingerprint: true)
            }
          }
          steps {
            sh '''
            ./gradlew build -x test
            '''
            sh 'ls -lrt'
          }
        }
        stage('Test') {
          post {
            always {
              junit 'build/test-results/test/*.xml'
            }
          }
          steps {
            sh './gradlew test'
          }
        }
        stage('SonarQube') {
          steps {
            withSonarQubeEnv('SonarGCloud') {
              sh 'sonar-scanner -Dproject.settings=sonar.properties -X'
            }
            sleep(10)
            waitForQualityGate true
          }
        }
    }
  }
