# CodePractice
practice coding problems

steps to push upstream:
1. if it's the first time pushing a project, do git init
2. git remote add origin https://github.com/[username]/[reponame].git
3. git add .   # this adds all the files
4. git pull https://github.com/[username]/[reponame].git  //just in case local and remote not in sync
5. git commit -a -m "comments" // this stages your files locally for commit.they haven't actually been pushed yet.
6. git push -u origin --all