pipeline {
    agent any

    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk11'
        nodejs 'AutomationTestNode'
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
