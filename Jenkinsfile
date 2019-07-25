pipeline {
  agent any
  environment {
      projectName = 'tns-devops-chucho'
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
    stage('Create Bucket/Update file') {
      steps {
            withAWS(credentials: 'awslab', region: 'us-east-1') {
                  cfnUpdate(stack: "${projectName}-s3", create: true, file: 's3.yaml', params: ["BucketNameLambda=${projectName}-bucket"])
                  s3Upload(bucket: "${projectName}-bucket", file: "${packageName}", workingDir: 'build/distributions/')
            }
        }
      }
    }
  }
