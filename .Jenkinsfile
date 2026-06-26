pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    triggers {
        cron('0 6 * * *')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/your-repo/testng-framework.git'
            }
        }

        stage('Build & Execute') {
            steps {
                bat 'https://github.com/gururajrkarnam/Interview.git'
            }
        }

        stage('Publish TestNG Report') {
            steps {
                publishHTML([
                    reportDir: 'test-output',
                    reportFiles: 'emailable-report.html',
                    reportName: 'TestNG Report',
                    keepAll: true
                ])
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'reports',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report',
                    keepAll: true
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/test-output/**/*'
        }
    }
}