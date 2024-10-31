
### TASKS

- DM Device Managment UI to assign nicknames or creatures to devices
- how to get the local ipv4 automatically to auto connect to backend (remove hardcoded ip)
- check Spell.java warning
- add connection error UI on fetch gamestate fail
- fill in some StatusEffects :D
- try to implement statuseffect procs with Spring @EventListener (test out by printing each step)
- convert Items from enum to class
- fill in items from 5eMagicItems.json, items.txt and 5eEquipment.json
- add unique slot icons (full and empty) to each TurnResource (also for custom)
- add addictions (statuseffects) to alcohol, {customLoreNarcotic} (where players get a buff until short rest when they use it, but then get a debuff for a week)
- maybe move api.ts requests to seperate files ?
- create a python script that generates this ˇˇ
- create a inheritable class tree for all json props of spells (with interfaces/abstract classes for different types - cones, spheres...)
- Change Spell structure, add Target class & enum (self, ally, enemy, aura, point, aoe, cone) that contains ranges, cones
- i might need a Source (for damage source, effect source...) object/class (this.Creature, this.Castable, this.StatusEffect)
- ItemEffect conversion
- finish races & subraces enums, classes and sublclasses enums
- weight and encumbered
- https://bg3.wiki/wiki/Weapon_actions
- add auto-calculation of base damage (stats + equipped weapon), AC, and a bunch of other stats
- finish all statuseffects enum
- update the spell descriptions by making them more descriptive and dnd-like (as a contrast to crpg-like) https://roll20.net/compendium/dnd5e/Index%3ASpells
- make a static playable races list in Race enum
- change "Elemental Weapon" spell so it doesn't give +1 to both Attack roll and damgae roll, but only to attack roll
- also need a appliesStatusEffect property of spell (clickable in log and can be dragged to a creature)
- move gamestate to folder (rename to save-DD-MM-YY or something)
- periodic saving to json (multiple json "saves", autoloads latest one) ~ every 2 minutes
- add ClassActions
- go look through monsters statblocks for missing statuseffects
- finish all spells list
- Creature.spellbook (will need primary ability of source of learned spell to calculate save DC), sort spellbook by school, ability to favourite spells
- prepared spells (how different classes do it)
- maybe sort race and class TurnResource counters to different objects/classes ?
- go through actual dnd (not bg3) subraces, subclasses, spells, conditions and add/modify the ones you have
- print shit out and save it to a log file simultaneously (NOT GAMESTATE)
- Go through each class, subclass, race and subrace and imagine trying to level them up
- seperate remaining tasks into DM UI and PlayerUI



### LOMBOK TAGS
@Data @AllArgs @NoArgs, @Builder, @Getter @Setter, @NoArgsConstructor, @RequiredArgsConstructor, @NonNull

- for model/ classes: @Data, @NoArgsConstructor, (#todo test @AllArgsContrcutor with lists), (optional @Builder)
- for controllers: nothing
- for dto: #todo (probably @Data)






#### STATS/PROFILE TAB
- add Skills

#### INVENTORY TAB
- item images from https://www.aidedd.org/dnd-filters/magic-items.php (move to ilia tasks)
- change item.lastModified on move between inventories (add function inventory.moveItem(itemIndex, otherInventory) or something)
- highlight item in inventory on move/modify
- add sorting options for inventory
- player inventory actions come as requests to me with checkmark or x to approve or dissmiss (ability to unlock inventories for 5 minutes and relock prematurely)
- stack splitting when transfering item
- add trading: buying and selling items (trader has buy and sell modifiers that can be changed by spells )
- add "pop" sound (similiar to minecraft item pickup) to equip and inventory actions

#### COMBAT/SCENE TAB
- need a scene Object class (Creature, Item and Object (tree, rock...) inherit from it) - has size, id
- player can see all the creatures on scene, actions he can take (with unavailable ones greyed out), full spellbook
- player can in combat see a list of Default Actions, Spells, Weapon Actions, Class Actions to choose from
- need to be able to display/preview summon's abilities before summoning them
- Item can be lootable, add ability to save inventories (probably to database) outside player's inventories (if they intentionally drop some bag), print out its location coordinates and inventories recursively 
- display resistances & relevant passives in combat (like minecraft)
- add a cancel drag n drop area on combat screen
- render bonus HP counter in a different color - orange

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

#### MAP TAB
- AC style vantage points for map discovery






### LOW PRIORITY IDEAS FOR LATER
- players roll investigation checks on combat start for each new creature type to see their stats and abilities in combat (like homm4 few, band, scores...), on failed roll -> statuseffects and stats greyed out
- add icons to statuseffects, spells, abilities
- add Artificer class
- convert to 5.5e










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
- koliki ce bit (u squares): PC movement range, spell range, improvised throw weapon range, 2 ranged weapon ranges (shorter one with disadvantage)
- gridmap aoe spells (nacrtat aoe grid za svaki radius, pregledat sve spellove za cudne oblike npr. cone i nacrtat kak ce to izgledat za razlicite rangeve)
- gridmap Wall of Fire ?
- kako funkcioniraju hit dice (short rest, long rest, levelup)
- koji ability za attack roll a koji za damage roll (napisi listu po klasama i tipovima oruzja ak treba nemam pojma)
- weapon types and scaling (finesse, versatile, martial...) https://bg3.wiki/wiki/Weapons#Properties
- nauci kak funkcionira git i github (zato da mi mozes contributat u kod bez mog inputa):
    - commands (add, commit, pull, push, branch, merge, pull request)
    - Feature branching Git workflow
- popuni TurnResourceType
- popuni subclasses u kodu na githubu (GameClass.java)
- promjeni spell upcastove u true na lv1 spellovima gdje treba
- if any spell mentions distance in meters (ex. 9 m): find description and convert to ft
- dodavat spellove koji fale u json-u i pregledat ove bg3 spellove koji su tu jel su isti efekti i ako nisu odabrat koji se cini bolji
- povezat spellove i status effecte u kodu
- convertat feet u squares svugdje u kodu

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















