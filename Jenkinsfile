pipeline {
  agent {
    docker {
      image 'maven:3.6.3-jdk-11-slim'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('UnitTest') {
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }

      }
      steps {
        sh 'mvn test'
      }
    }

    stage('ApiTest') {
      steps {
        sh "echo $PATH"
        sh 'npm install newman'
        sh 'run newman ./postman/scorecard-template-api.json'
      }
    }

  }
}