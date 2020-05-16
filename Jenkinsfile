pipeline {
    agent any

    docker {
        image 'maven:3.6.3-jdk-11-slim'
        args '-v /root/.m2:/root/.m2'
    }
    
    tools {
        nodejs "AutomationTestNode"
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
                sh "npm install newman"
                sh "run newman ./postman/scorecard-template-api.json"
            }
        }
   }
}