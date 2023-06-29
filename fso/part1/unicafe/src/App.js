import { useState } from 'react'

const Button = (props) => (
  <button onClick={props.handler}>
    {props.text}
  </button>
)

const Statistics = (props) => {
    let i = 0;
    Object.values(props.stats).forEach(x=> i += x)
    if (i < 1) {
        return (
            <p>No feedback given</p>
        )
    }

    return(
       <>
        <h1>statistics</h1>
        <StatisticLine text={"good"} value={props.stats.good} />
        <StatisticLine text={"neutral"} value={props.stats.neutral} />
        <StatisticLine text={"bad"} value={props.stats.bad} />
        <StatisticLine text={"all"} value={props.stats.all} />
        <StatisticLine text={"average"} value={props.stats.average} />
        <StatisticLine text={"positive"} value={props.stats.positive} percentage={"%"} />
    </>
    )
}

const StatisticLine = (props) => {
    return(
        <p>{props.text} {props.value} {props.percentage}</p>
    )
}



const App = () => {
  // tallenna napit omaan tilaansa
  const [good, setGood] = useState(0)
  const [neutral, setNeutral] = useState(0)
  const [bad, setBad] = useState(0)
  const [all, setAll] = useState(0)
  const [average, setAvg] = useState(0)
  const [positive, setPos] = useState(0)
    const data = {
      good,
        neutral,
        bad,
        all,
        average,
        positive
    }

    const handleGoodClick = () => {
      setGood(good => good + 1)
      setAll(all => all + 1)
      const avg = (good+1-bad)/(all+1)
      setAvg(avg)
      const pos = (good+1)/(all+1)*100
      setPos(pos)
    }
  const handleNeutralClick = () => {
      setNeutral(neutral +1)
      setAll(all => all + 1)
      const avg = (good-bad)/(all+1)
      setAvg(avg)
      const pos = good/(all+1)*100
      setPos(pos)
  }
  const handleBadClick = () => {
      setBad(bad +1)
      setAll(all => all + 1)
      const avg = (good-bad-1)/(all+1)
      setAvg(avg)
      const pos = (good)/(all+1)*100
      setPos(pos)
  }

  return (
    <div>
      <h1>give feedback</h1>
      <br/>
      <Button handler={handleGoodClick} text={"good"} />
      <Button handler={handleNeutralClick} text={"neutral"}/>
      <Button handler={handleBadClick} text={"bad"} />
      <br/>
      <Statistics stats={data} />
    </div>
  )
}

export default App