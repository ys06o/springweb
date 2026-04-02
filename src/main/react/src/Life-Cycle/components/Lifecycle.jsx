import { useEffect, useState } from "react"

function MoveBox(props) {
  const [position, setPosition] = useState(props.initPosition);
  const [leftCount, setLeftCount] = useState(1);

  const boxStyle = {
    backgroundColor: 'red',
    position: 'relative', 
    left: `${position}px`,
    textAlign: 'center',
    width: '100px', 
    height: '100px', 
    margin: '10px'
  }

  const moveLeft = () => {
    setPosition(position - 20);
    setLeftCount(leftCount + 1);
  };

  const MoveRight = () => {
    setPosition(position + 20);
  };

  useEffect(function () {
    console.log("3. useEffect 실행 (마운트 또는 leftCount 변경)");
    return () => {
      console.log("0. 클린업 실행");
    }
  }, [leftCount]);

  console.log("2. return 실행 (렌더링)");

  return (
    <>
      <div>
        <h4>함수형 컴포넌트의 생명주기</h4>
        <div style={boxStyle}>BOX</div>
        
        <div>좌측 이동 횟수: {leftCount}</div>
        <div>현재 위치: {position}px</div>
        <input type="button" value="좌측이동" onClick={moveLeft} />
        <input type="button" value="우측이동" onClick={MoveRight} />
      </div>
    </>
  );
}

export default function Lifecycle(props) {
  return (
    <>
      <h2>Lifecycle 예제</h2>
      <MoveBox initPosition={50}></MoveBox>
    </>
  )
}