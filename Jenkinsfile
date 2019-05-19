pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                /*
                dir('backend') {
                    sh 'mvn clean'
                    sh 'mvn package -Dmaven.test.skip=true'

                    dir('login') {
                        sh 'mvn dockerfile:build'
                    }

                    dir('play') {
                        sh 'mvn dockerfile:build'
                    }
                }
                */
                dir('frontend') {
                    sh 'echo $PATH'
                    sh 'nvm list'
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Testing..'
                /*
                dir('backend') {
                    sh 'mvn test'
                }
                */
                dir('frontend') {
                    sh 'npm install'
                    sh 'npm test'
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
