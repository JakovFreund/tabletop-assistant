
### TASKS

- make a proof-of-concept frontend combat simulator
    - create combat log on the backend
    - integrate the whole combat system with backend (castables/actions, )
    - apply statuseffect to creature
    - implement weapon modifiers


- color scheme for frontend ? (dark red, black + desaturated yellow parchment)

- fill in default WeaponTypes
- add try-catch to all service/controller files ( #todo ask chatgpt which ones, and should i add to to higher level classes or lower) in case of bad requests
- read how mounts work in 5e raw?
- mounts will work like creatures attached to the creature riding them (boosting their speed?), they have a turn in combat but cannot move if somebody is riding them.
- Mount.java (class for mounts from 5e-Equipment.json with all stats (speed, capacity...))
- search all files for HashMaps and ArrayLists and consider converting to Maps and Lists (research best practices for Java in general and Jackson specifically)
- shorten StatusEffects by finding common denominators (ex. can't take Actions)
- go through all spells and make status effects if there isn't one
- how to get the local ipv4 automatically to auto connect to backend (remove hardcoded ip from WebConfig.java and api.ts) OR move it to a config file
- add connection error UI on fetch gamestate fail
- do i need StatusEffectInstance.removedOnSourceLostConcentration
- for the statuseffects you can't proc because of unknown variables or impossible implementation: print out what must happen to log (with a #needsDMaction tag or something) if StatusEffect isn't programmed in or requires player action (add special ui/notification for that)
- implement the StatusEffectInstance dependsUpon() (careful for multiple sources) and removeOnSourceLostConcentration() ?
- implement concentration loss and removal of statuseffects from other creatures
- should i implement statuseffect procs with Spring @EventListener
- i can implement the status effects related to caster (ex. Friends) using statuseffectinstance.source.creatureId 
- add unique slot icons (full and empty) to each TurnResource (also for custom)
- add addictions (statuseffects) to alcohol, {customLoreNarcotic} (where players get a buff until short rest when they use it, but then get a debuff for a week)
- maybe move api.ts requests to seperate files ?
- is device stuff in my redux store redundant? for example state.device, state.gamestate.devices, state.gamestate.deviceMappings, state.connectedDevices ? should this all be in state.devices ?
- research and possibly implement store.useAppDispatch
- fix and cleanup frontend completely
    - what's redundant
    - the structure, hierarchy
    - repeated stuff
    - redux store
- CreatureService.removeConcentration(Creature) - check other creatures for matching statuseffects that need to be removed
- when you drag a statuseffect on a creature, specify if saving throw is needed, what DC, and if affected creature has proficiency in that saving throw
- ^^ If saving throw needed, pop-up that inputs roll amount and adds proficiency, skill modifier or whatever is needed. (log "Saving throw failed..." with all info)
- implement remove status effect on lost concentration
- add rogue expertise statuseffect for all skills
- add fantasy datetime to gamestate (check dnd lore, should i use 12 months and 365 days of something else?)
- fill in race movement speeds
- finish races & subraces enums
- weight and encumbered
- add ClassActions
- add default actions (Grab, Shove, Throw, Help, Dash...) - DefaultActions.java ?
- implement existing ItemEffects
- go through MagicItems descriptions and add ItemEffects and StatusEffects
- fill in MagicItems weapons and armour stats
- add generateRandomItem() + on weapon/armour creation randomly determine rarity upgrade (yes or no boolean) and then add 1 effect or none
- the environment/scene has an inventory (where ItemStacks go when players drop them)
- DM also has a seperate inventory
- https://bg3.wiki/wiki/Weapon_actions (add them to WeaponType and WeaponAttributes)
- add auto-calculation of base damage (stats + equipped weapon), AC, and a bunch of other stats
- finish all statuseffects enum
- double check each StatusEffect included effects
- make a static playable races list in Race enum
- change "Elemental Weapon" spell so it doesn't give +1 to both Attack roll and damgae roll, but only to attack roll
- check out weapon StatusEffect implementation (MAGIC_WEAPON, PACT_WEAPON...). Can items have StatusEffects?
- also need a appliesStatusEffect property of spell (clickable in log and can be dragged to a creature)
- move gamestate to folder (rename to save-DD-MM-YY or something)
- periodic gamestate saving (saves both to "latest.json" and "backups/21-02-24-12-37-30.json", on start autoloads latest) ~ saves every 2 minutes
- render different damage types and heals differently (create react objects for them?)
- go look through monsters statblocks for missing statuseffects
- Creature.spellbook (will need primary ability of source of learned spell to calculate save DC), sort spellbook by school, ability to favourite spells
- prepared spells (how different classes do it)
- maybe sort race and class TurnResource counters to different objects/classes ?
- which font should i use on frontend?
- print shit out and save it to a log file simultaneously (not gamestate)
- need to program warlock spellslot spending seperately (can spend wl spellslot instead of nromal if spell level is the same or less...)
- Go through each class, subclass, race and subrace and imagine trying to level them up
- seperate remaining tasks into general, DM UI and PlayerUI
- test if spell duration is properly implemented - duration needs to be reduced by 1 on end of turn or start of turn? (ex. True Strike needs to end on next turn)
- time controls (play, pause, speed, increment a specific amount in either direction, undo(gamestate rollback))
- manually check SpellData if spell upcast booleans are accurate
- spells that have multiple damage types were wrong in the json, fix manually in SpellData
- on combat end convert currently active castable costs (channeling) to a custom StatusEffect "CASTING_SPELL" with the same Duration
- ^^ or maybe do that immidietly for any channeling (instead of using an action every turn just have a CHANNELING statuseffect that prohibits use of action)
- css google when should i target element by tag/type vs className
- go through all css classNames and change them accordingly
- add monochrome icons (display in corner) and descriptions to StatusEffect Status Groups
- spirit guardians spell aoe wrong in json
- add all wild magic statuseffects from 5e
- subracial default images (duochrome outlines with different colors - similar to icons from https://www.dndbeyond.com/monsters)
- have the same-race subraces have similar colors
- ^^ same for item categories (note: weapons have a default icon of an axe crossed with a sword if there is no difference between weapon types (swords, axes...))
- players with aura effect have to remember to apply them since app doesn't keep track of position
- fully obscured, half obscured, partial cover ?
- look at other bg3 homebrew rules and maybe add some to my house rules list
- Long range (with disadvantage) for both throwing and shooting is always 3 times the normal range
- Two-handing a versitile weapon gives a +2 bonus to damage
- make a rules reminder list
- add keybinds to MasterInterface actions
- rename and categorize frontend image resources, cleanup public folder
- pre-map the finished creatures to deviceNicknames
- geographical areas aoe buffs and debuffs yugioh field spell style
- add a hungry status effect that gives a small debuff
- the DM can edit items, statuseffects, characters stats, and everything you can think of (need to add interfaces/menus for all that)
- DM can search all ItemData, SpellData and StatusEffects and add them to his inventory where they can be edited (items get random id on clone - itemIDs in ItemData don't matter)
- use Jackson to save ItemData and SpellData to jsons and load them on startup (add "outdated" comment to .py scripts)
- advanced character sheet (when you click on a stat it shows you how it got that nunber - formula and subnumbers)
- each creature has a known spell list/statuseffect list and when they view another creature they see "unknown" status effects
- PCs can learn of a statusEffect, subrace or item by reading a book about it, and they gain it to the known list (also gained if another PC tells them about it)
- creature.knownStatusEffects (StatusEffect), knownSubraces (Subrace), knownItems (UUID for Items with item.needsIdentify: true)


#### STATS/PROFILE TAB
- add Skills

#### INVENTORY TAB
- no custom item sorting... (only favorite to show on top, otherwise autosort)
- item images sources:
    - have both the ItemCategory (and WeaponType) default icon and optional unique icon
    - https://www.dndbeyond.com/magic-items
    - https://www.dndbeyond.com/equipment
    - others:
        - HD images https://www.aidedd.org/dnd-filters/magic-items.php 
        - drawn but cartoonish https://github.com/Gwillewyn/dnd-item-icons-by-gwill
- change item.lastModified on move between inventories (add function inventory.moveItem(itemIndex, otherInventory) or something)
- highlight item in inventory on move/modify
- add sorting options for inventory
- player inventory actions come as requests to me with checkmark or x to approve or dissmiss (ability to unlock inventories for 5 minutes and relock prematurely)
- stack splitting when transfering item
- add trading: buying and selling items (trader has buy and sell modifiers that can be changed by spells )
- add "pop" sound (similiar to minecraft item pickup) to equip and inventory actions

#### COMBAT/SCENE TAB
- need a SceneObject class (Creature, Item and Object (tree, rock...) inherit from it) - has size, id
- DM UI to create a Damage object with all properties
- player can see all the creatures on scene, actions he can take (with unavailable ones greyed out), full spellbook
- player can in combat see a list of Default Actions, Spells, Weapon Actions, Class Actions to choose from
- need to be able to display/preview summon's abilities before summoning them
- Item can be lootable, add ability to save inventories (probably to database) outside player's inventories (if they intentionally drop some bag), print out its location coordinates and inventories recursively 
- display resistances & relevant passives in combat (like minecraft)
- add a cancel drag n drop area on combat screen
- render bonus HP counter in a different color - orange
- player UI when selecting an attack, show percentage to hit AC on each target like in bg3 (how do i do this if players don't input attacks and select targets?)
- players see all included status effects when they view a creature

##### COMBAT LOG
- make eldritch blast have 3 different damage components that have the same damageType
- CastableDamage gets turned into Damage between ping and input
- add a CastableHeal object aswell - because of source and drag n dropping
- a the bottom of the screen is a log (player pings, DM pings, DM actions/changes all go there), has ability to filter only DM actions
- add a clickable damage object in log that auto copies the damage into calculator (or just queues text pointer on appropriate damage types)
- when a player pings a spell, the log prints out all the info and buttons for the DM which i can use to autosubtract turnresources, autofocus damage textboxes (by drag n droping damage on the target creature and just entering appropriate amounts for each type, also autofill in if not dice notation) autoapply statuseffect by drag n drop (with info about the target type [self, enemy...] for clearer gameflow)
- the players see colored labels instead of buttons so they can't use them
- when taking damage and checking StatusEffects (ex. resistances) there is an empty list of possible procs and procs get added if true so output can be ˇˇ
- "(0, 10, 0, 6, 0, 0, 0) -> Goblin has taken 8 damage (COLD_RESISTANCE, POISON_RESISTANCE)"
- Creature.cast() players can ping spells and attacks (Flint casts Icebolt and it does 3d6+5 frost damage) (Flint uses melee attack and it does 3d6+5 bludgeoning damage)
- players can also ping consumables (prints clickable heal/addStatusEffect, consume item, TurnResource costs)
- players don't have to ping just to get information (it's already calculated for each spell)
- clear combat log button (with "are you sure?" prompt)
- creature end turn displays in combat log (and start of next creature's turn)

#### MAP TAB
- fog of war + AC style vantage points for map discovery (or more like elden ring map location that discovers an entire area but instead its a vantage point) - make it distinct on the map
- send full map and discovered mask through endpoint, mask image on frontend (don't overlay)
- 3 props: x, y, zoom
- active visibility on the map is determined by day/night, geographical area and racial eyesight
- add option for DM to "freeze" PC movement on the map while time can still pass (routes stay intact) - usecase for rests, encounters, dungeons, cities...
- legend (different types of landmark points for city, village, fort, natural landmark)

```jsx
import { useGesture } from 'react-use-gesture';

function MyComponent() {
  const bind = useGesture({
    onDrag: ({ delta }) => {
      // Dragging logic
    },
    onPinch: ({ offset }) => {
      // Pinch zoom
    },
    onWheel: ({ delta }) => {
      // Scroll/wheel interactions
    }
  });

  return <div {...bind()}>Touch me</div>;
}
```

- dm can teleport characters or set their destination
- route can have checkpoints


### LOW PRIORITY IDEAS FOR LATER
- players roll investigation checks on combat start for each new creature type to see their stats and abilities in combat (like homm4 few, band, scores...), on failed roll -> statuseffects and stats greyed out
- add icons to statuseffects, spells, abilities
- add Artificer class
- convert to 5.5e
- modify high level spells with a high material cost (or which the spell consumes) to have some sort of penalty/limitation so PCs can't spam them
- keep monster AC secret (TODO maybe reveal it either on hit or if a character has some proficiency when he gets closer) instead describe the armour that he is wearing and maybe his class



### Windows Hard link command

```batch
mklink "E:\Alexandria\D&D\tabletop-assistant-tasks-copy.md" "E:\Programming\tabletop-assistant\tasks.md"
```


### Obsidian render

```md
<center><iframe width="800" height="500" src="https://github.com/JakovFreund/tabletop-assistant/blob/main/tasks.md#ilia-tasks"></iframe></center>
```




### ILIA TASKS

- DMG pg250 procitaj cijeli section pa mi daj tldr slj tjedan
- procitaj Players Handbook "Resting" section za Hit Dice info
- gridmap aoe spells (nacrtat aoe grid za svaki AreaType.java, pregledat sve spellove i nacrtat kak ce to izgledat za razlicite rangeve - npr. Wall of Fire)
- kako funkcioniraju hit dice (short rest, long rest, levelup)
- do spell attack rolls have the longer range (with disadvantage)?
- koji ability za attack roll a koji za damage roll (napisi listu po klasama i tipovima oruzja ak treba nemam pojma)
- weapon types and scaling (finesse, versatile, martial...) https://bg3.wiki/wiki/Weapons#Properties
- prepared spells (how different classes do it), types of spellcasters? (spell refill and spend type)
- nauci kak funkcionira git i github (zato da mi mozes contributat u kod bez mog inputa):
    - commands (add, commit, pull, push, branch, merge, pull request)
    - Feature branching Git workflow
- popuni TurnResourceType
- popuni klase u kodu na githubu (Subclass.java)
- Background.java descriptions
- https://bg3.wiki/wiki/List_of_all_spells
- dodaj spellove koji fale (izlistano dolje u ### BG3 spells missing from 5eSpells.json) u SpellData.java na dno postojece liste (ne abecedno)
- pregledaj te bg3 spellove jesu li isti efekti u bg3 i 5e, i ako nisu odabrat koji se cini bolji
- povezi spellove i status effecte u kodu (SpellData.java -> Spell.statusEffects List<StatusEffect>)
- zaokruzi feet koji nisu djeljivi sa 5
- frontend css

RULES:

[google drive download link for all 3:](https://drive.google.com/drive/folders/1fJvKEWDJ7MjdcF3NVsntdT7wIlEm06JC?usp=sharing)
- DnD 5e Players Handbook
- D&D 5e Dungeon Master's Guide
- 5th Edition - Essentials Kit Rulebook

### BG3 spells missing from 5eSpells.json

#### CANTRIPS
- Blade Ward
- Bone Chill = Chill Touch
- Friends
- Thorn Whip

#### LEVEL 1
- Armour of Agathys
- Arms of Hadar
- Chromatic Orb
- Compelled Duel
- Dissonant Whispers
- Enhance Leap = Jump
- Ensnaring Strike
- Hail of Thorns
- Hex
- Ice Knife
- Ray of Sickness
- Searing Smite
- Shield of Faith
- Tasha's Hideous Laughter = Hideous Laughter
- Thunderous Smite
- Witch Bolt
- Wrathful Smite

#### LEVEL 2
- Cloud of Daggers
- Crown of Madness
- Melf's Acid Arrow = Acid Arrow
- Phantasmal Force

#### LEVEL 3
- Blinding Smite
- Conjure Barrage
- Crusader's Mantle
- Elemental Weapon
- Feign Death
- Grant Flight = Fly
- Hunger of Hadar
- Lightning Arrow
- Warden of Vitality

#### LEVEL 4
- Evard's Black Tentacles = Black Tentacles
- Grasping Vine
- Otiluke's Resilient Sphere = Resilient Sphere

#### LEVEL 5
- Curriculum of Strategy: Artistry of War
- Banishing Smite
- Destructive Wave
- Dethrone
- Arcane Gate

#### LEVEL 6
- Otiluke's Freezing Sphere = Freezing Sphere
- Otto's Irresistible Dance = Irresistible Dance















