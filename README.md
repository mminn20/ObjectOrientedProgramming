## 📖 Object Oriented Programming 객체지향프로그래밍 과제 

</br>

### 1. Lab Project 0 - 2048 Game

📌 <a href="https://mminn.notion.site/Lab-Project0-1b889ff14d21804fb06cec0c09565d86?pvs=4"> Lab Project 0 과제 설명 정리 </a></br>
📌 <a href="https://mminn.notion.site/Lab-Project0-923777a68a32430788a10f4d6797d098"> Lab Project 0 구현 결과 정리 </a></br>
📌 <a href="https://github.com/mminn20/ObjectOrientedProgramming/tree/main/proj0/game2048"> Github 레포지토리 경로 </a></br>

Lab 0 프로젝트의 주요 과제는 2048 게임을 완성하는 것입니다. </br>
Model.class, emptySpaceExists, maxTileExists, atLeastOneMoveExists, title 등을 작성하고, 테스트를 통과해야 합니다. </br>

</br>
Main tasks of the lab project 0 is to modify and complete the game of 2048. </br>
Especially, the `model` class, and the following methods - `emptySpaceExists` , `maxTileExists` , `atLeastOneMoveExists` and `tilt`. </br>

</br>
As you might know, game rules of the 2048 go like this : </br>
1. Two tiles of the same value merge into one tile containing double the initial number. </br>
2. A tile that is the result of a merge will not merge again on that tilt. → 이동 후 같은 수를 가진 타일이 2개가 되어도, 그 턴은 이동이 주 목적이어서 바로 더해지지 않는다. </br>
3. When three adjacent tiles in the direction of motion have the same number, then the leading two tiles in the direction of motion merge, and the trailing tile does not. → 이동방향의 행/열과 가장 근접한 두 타일이 합쳐지고, 가장 먼 하나의 타일은 더해지지 않는다.</br>


</br></br>

### 2. Lab Project 1 - 자료구조 구현 (Deque, LinkedListDeque, ArrayDeque, MaxArrayDeque) 

📌 <a href="https://www.notion.so/mminn/Lab-Project2-b41df98058ac499d966c6270708c0229"> Lab Project 1 과제 설명 </a></br>
📌 <a href="https://mminn.notion.site/Lab-Assignment2-144b71de2a634f14bd1e2f3036544f04?pvs=4"> Lab Project 1 구현 결과 정리 </a></br>
📌 <a href="https://github.com/mminn20/ObjectOrientedProgramming/tree/main/proj1"> Github 레포지토리 경로 </a></br>

Lab Project 1의 주요 과제는 자료구조를 구현하는 것입니다. </br>
Deque, LinkedListDeque, ArrayDeque, MaxArrayDeque 자료구주를 직접 구현하고, 테스트를 작성했습니다.  </br>

For lab project 1, you should implement your own data structure. </br>
Implement an interface `Deque`, then create a `LinkedListDeque` class and an `ArrayDeque` class that implements the Deque interface, and a `MaxArrayDeque` class extends ArraryDeque.</br>



