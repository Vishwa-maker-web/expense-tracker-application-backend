pipeline {
    agent any
    
    tools {
        maven 'maven3'
    }
    
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean install -DskipTests'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
