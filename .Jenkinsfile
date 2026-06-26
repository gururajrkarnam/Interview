pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK11'
    }

    triggers {
        cron('0 6 * * *')
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Execute Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'test-output/**/*', allowEmptyArchive: true

            junit testResults: 'target/surefire-reports/*.xml',
                  allowEmptyResults: true
        }

        success {
            echo 'Tests executed successfully'
        }

        failure {
            echo 'Tests failed'
        }
    }
}