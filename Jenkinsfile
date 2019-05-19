pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                dir('backend') {
                    sh 'ls'
                    sh 'mvn clean'
                    sh 'mvn package -Dmaven.test.skip=true'
                }    
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                dir('backend') {
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
    }
}
