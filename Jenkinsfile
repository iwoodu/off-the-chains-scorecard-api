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
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('ApiTest') {
            steps {
                run newman ./postman/scorecard-template-api.json
            }
        }
   }
}