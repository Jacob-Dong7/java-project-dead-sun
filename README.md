<h1 align="center">❄️ Road to Terminus - Work In Progress</h1>

<p align="center">
    <b>A post-apocalyptic, text-based survival RPG built in Java.</b><br/>
    Atmospheric exploration • Tactical combat • Trading & inventory management • Modular OOP architecture
</p>

<p align="center">
    <img alt="Java" src="https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
    <img alt="Platform" src="https://img.shields.io/badge/Platform-Terminal%20%2F%20CLI-2D2D2D?style=for-the-badge"/>
    <img alt="Status" src="https://img.shields.io/badge/Status-In%20Development-5C7CFA?style=for-the-badge"/>
</p>

<p align="center">
    <i>The generators fade behind you. The ash begins to fall.</i>
</p>

<hr/>

<br/>

<h2>🌍 Premise</h2>

<p>
    In 2076, tectonic instability triggered simultaneous volcanic eruptions across the globe.
    Ash blotted out the sun. Temperatures collapsed. Governments dissolved within days.
</p>

<br/>

<p>
    Nearly 98% of humanity perished in the years that followed.
    The world became a frozen ruin — silent streets, collapsed infrastructure, and settlements surviving on borrowed power.
</p>

<br/>

<p>
    You begin in a fragile pocket of safety and step outward into the surface: searching, fighting, scavenging,
    and trading to stay alive long enough to push deeper.
</p>

<br/>

<hr/>

<br/>

<h2>🧭 How the Game Plays</h2>

<p>
    Road to Terminus is designed around a clear gameplay loop that escalates naturally.
    You start safe, prepare carefully, then venture into danger — and return if you survive.
</p>

<br/>

<table>
    <thead>
        <tr>
            <th align="left">Phase</th>
            <th align="left">Description</th>
            <th align="left">Impact</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><b>1) Character Setup</b></td>
            <td>Create Character Builds</td>
            <td>Different build can do different things</td>
        </tr>
        <tr>
            <td><b>2) Settlement Prep</b></td>
            <td>Trade, organize inventory</td>
            <td>Limited stock constraints</td>
        </tr>
        <tr>
            <td><b>3) Travel</b></td>
            <td>Move through locations</td>
            <td>Difficulty rises the further you go</td>
        </tr>
        <tr>
            <td><b>4) Encounters</b></td>
            <td>Combat / stealth / speech</td>
            <td>Resource depletion directly affects survivability</td>
        </tr>
        <tr>
            <td><b>5) Loot & Recovery</b></td>
            <td>Scavenge supplies</td>
            <td>Resource management decides your next fight</td>
        </tr>
        <tr>
            <td><b>6) Return / Push Forward</b></td>
            <td>Return to safety or continue exploring</td>
            <td>Risk accumulation scales against preparation</td>
        </tr>
    </tbody>
</table>

<br/>

<hr/>

<br/>

<h2>🏘 Settlements</h2>

<h3>🛒 New Concourse</h3>

<p>
    A trading hub built inside an abandoned mall.
    The first safe zone you will encounter. Allow you to stock up.
</p>

<br/>

<ul>
    <li><b>Safe zone</b> for preparation and recovery</li>
    <li><b>Trading hub</b> with a variety of goods</li>
</ul>

<br/>

<hr/>

<br/>

<h2>🧑‍💼 Trading & Vendors</h2>

<p>
    Traders are named NPC vendors that can sell medicines, ammo or weapons.
    Easy to read UI (aligned columns, prices, stats, and availability).
</p>

<br/>

<h3>🩹 Clara — Medical & Supplies (New Concourse)</h3>

<ul>
    <li>Healing items</li>
    <li>Ammunitions</li>
    <li>Supports longer surface runs</li>
</ul>

<br/>

<h3>🔫 Joe — Weapons & Arms (New Concourse)</h3>

<ul>
    <li>Large weapon selection</li>
    <li>Help player combat</li>
</ul>

<br/>

<br/>

<hr/>

<br/>

<h2>⚔️ Encounters & Combat</h2>

<p>
    Encounters form the core tension of Road to Terminus.
    Each run is unqiue with varying numbers of enemies you will encounter.
</p>

<br/>

<ul>
    <li><b>Turn-based combat</b></li>
    <li><b>Weapon stats</b></li>
    <li><b>Healing</b> — wasting supplies is punished later</li>
    <li><b>Multiple approaches</b> combat / stealth / speech</li>
</ul>

<br/>

<hr/>

<br/>

<h2>🎒 Inventory</h2>

<p>
    Resource management is a main design focus.
    The game is intentionally stingy.
</p>

<br/>

<ul>
    <li><b>Credits / Money</b> used for trading</li>
    <li><b>Healing items</b> has decent variety, crucial for surviving</li>
    <li><b>Weapons</b> define your combat</li>
    <li><b>Ammo</b> important as lacking it will make alot of powerful weapons useless</li>
</ul>


<hr/>
<hr/>

<br/>

<h2>✨ UI & Presentation</h2>

<p>
    The UI is structured to feel like a real game menu system:
    separators, aligned columns, headings, and readable lists.
</p>

<br/>

<ul>
    <li>Consistent section (locations, trading, inventory)</li>
    <li>Readable shop tables</li>
    <li>Clear prompts and menu choices</li>
</ul>


<h2>▶ Running the Project</h2>

<p>
    Compile and run from the project root:
</p>

<br/>

<pre>
mkdir out 2>nul
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt

java -cp out Main
</pre>

<br/>

<ul>
    <li>Requires <b>Java 17+</b></li>
    <li>Runs in a standard terminal (Windows / macOS / Linux)</li>
</ul>

<br/>

<hr/>

<br/>

<h2>🛠 Roadmap</h2>

<ul>
    <li><b>Level up system so user can keep upgrading stats</b></li>
    <li><b>More encounters</b> (enemy variety and bosses)</li>
    <li><b>Finish story</b> (more location, settlements and eventually the ending)</li>
</ul>

<br/>

<hr/>

<br/>
