pipeline{

    agent any

   tools{
       maven 'manasa_maven'

   }
   /*parameters {
      choice choices: ['development', 'master'], description: 'This job is parametrized', name: 'BranchName'
   }*/

   triggers{
    pollSCM('* * * * *')
   }

   options{
      timestamps()
      buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5'))
   }

  stages{

     stage('CheckOutCode'){
       steps{
	       git branch: 'main', url: 'https://github.com/srinath-17/srisgame.git'
	
	   }
     }
  
     stage('Build'){
        steps{
          sh  "mvn clean package"
        }
     }
  /*  stage("Build sample project Job"){
	    steps{
		   build job: 'sris_game_testing_proj_dev'
	    }
    }*/
    stage("Deploy To Kuberates Cluster"){
       kubernetesDeploy(
         configs: 'deployment.yml', 
         kubeconfigId: 'KUBERNATES_CONFIG',
         enableConfigSubstitution: true
        )
     }
	 
	  /**
      stage("Deploy To Kuberates Cluster"){
        sh 'kubectl apply -f deployment.yml'
      } **/
  }
 post {
    always {
        script {
            def branch_name = sh(
                script: 'git rev-parse --abbrev-ref HEAD',
                returnStdout: true
            ).trim()

            def commit_id = sh(
                script: 'git rev-parse HEAD',
                returnStdout: true
            ).trim()

            def build_number = currentBuild.number

            def build_user = env.BUILD_USER_ID
            def build_name = "This was done by ${build_user} on ${branch_name}-${commit_id}-${build_number}"
            
            currentBuild.displayName = build_name
        }
    }
  }
}
